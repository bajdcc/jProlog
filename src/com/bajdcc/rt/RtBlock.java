package com.bajdcc.rt;

import com.bajdcc.ast.block.Block;
import com.bajdcc.ast.exp.*;
import com.bajdcc.ast.stmt.*;
import com.bajdcc.ast.token.TId;
import com.bajdcc.ast.token.TLiteral;
import com.bajdcc.ast.token.TNumber;
import com.bajdcc.ast.token.TRange;
import com.bajdcc.rt.adv.exp.*;
import com.bajdcc.rt.adv.func.RtFuncFactory;
import com.bajdcc.rt.adv.func.RtValidFunc;
import com.bajdcc.rt.adv.token.RtTNumber;
import com.bajdcc.rt.adv.token.RtTString;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.symbol.RtSymbol;
import com.bajdcc.rt.symbol.ValType;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstVisitor;

import java.util.List;

/**
 * 重构AST
 */
public class RtBlock implements IAstVisitor {

    private boolean init = true;
    private final RtBlockOriginStruct origin;
    private final RtStack stack;
    private final RtStack stackExp;
    private final RtSymbol symbol;
    private final RtTreeExpBuilder tree;
    public RtBlock() {
        origin = new RtBlockOriginStruct();
        stack = new RtStack();
        stackExp = new RtStack();
        symbol = new RtSymbol();
        tree = new RtTreeExpBuilder();
    }

    public RtSymbol getSymbol() {
        return symbol;
    }

    public void visitAgain() throws Exception {
        if (init) {
            init = false;
            visitAgainInternal();
        }
    }

    private void visitAgainInternal() throws Exception {
        visitAgainSeparator(origin.getSet());
        visitAgainSeparator(origin.getSin());
        visitAgainSeparator(origin.getSeq());
        visitAgainSeparator(origin.getArg());
        visitAgainSeparator(origin.getCond());
    }

    private void visitAgainSeparator(List<? extends IStmt> list) throws Exception {
        for (IStmt stmt : list) {
            stmt.visit(this);
        }
    }

    @Override
    public void visitBegin(Block node, AstVisitorArgs args) throws Exception {

    }

    @Override
    public void visitEnd(Block node) throws Exception {

    }

    @Override
    public void visitBegin(CollectionStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.disableVisitChildren();
            args.disableVisitEnd();
            origin.getSet().add(node);
        }
    }

    @Override
    public void visitEnd(CollectionStmt node) throws Exception {

    }

    @Override
    public void visitBegin(ConditionStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.disableVisitChildren();
            args.disableVisitEnd();
            origin.getCond().add(node);
        } else {
            stack.push(StateType.COND);
            if (node.getQuantifiers() != null) {
                stackExp.push(StateType.QUAN);
            }
        }
    }

    @Override
    public void visitEnd(ConditionStmt node) throws Exception {
        stack.pop();
        symbol.registerFunc(tree.getFunc());
        tree.clearFunc();
    }

    @Override
    public void visitBegin(SingleVariableStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.disableVisitChildren();
            args.disableVisitEnd();
            origin.getSin().add(node);
        }
    }

    @Override
    public void visitEnd(SingleVariableStmt node) throws Exception {

    }

    @Override
    public void visitBegin(SequenceVariableStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.disableVisitChildren();
            args.disableVisitEnd();
            origin.getSeq().add(node);
        }
    }

    @Override
    public void visitEnd(SequenceVariableStmt node) throws Exception {

    }

    @Override
    public void visitBegin(ArgumentVariableStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.disableVisitChildren();
            args.disableVisitEnd();
            origin.getArg().add(node);
        }
    }

    @Override
    public void visitEnd(ArgumentVariableStmt node) throws Exception {

    }

    @Override
    public void visitBegin(CollectionExp node, AstVisitorArgs args) throws Exception {
        stack.push(StateType.SET, node.getType());
        symbol.registerType(node.getType().toString());
    }

    @Override
    public void visitEnd(CollectionExp node) throws Exception {
        stack.pop();
    }

    @Override
    public void visitBegin(ArgumentExp node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            tree.push(new RtArgs());
            if (stackExp.top().getType() != StateType.QUAN) {
                stackExp.push(StateType.PARAM);
            }
        }
    }

    @Override
    public void visitEnd(ArgumentExp node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            RtExp args = tree.current();
            tree.pop();
            if (stackExp.top().getType() != StateType.QUAN) {
                tree.current().check(symbol, new Object[]{args.getChilren().size()});
            }
            stackExp.pop();
        }
    }

    @Override
    public void visitBegin(SingleVariableDefExp node, AstVisitorArgs args) throws Exception {
        stack.push(StateType.SIN, node.getType());
    }

    @Override
    public void visitEnd(SingleVariableDefExp node) throws Exception {
        stack.pop();
    }

    @Override
    public void visitBegin(SingleVariableExp node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.SIN) {
            symbol.registerSingleVariable(state.getToken().toString(), node.getId().toString());
            args.disableVisitChildren();
            args.disableVisitEnd();
        } else if (state.getType() == StateType.COND) {
            tree.push(new RtVar(ValType.SINGLE,
                    symbol.query(String.valueOf(node.getId().getValue()), ValType.SINGLE)));
            stackExp.push(StateType.SIN);
        }
    }

    @Override
    public void visitEnd(SingleVariableExp node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            tree.pop();
            stackExp.pop();
        }
    }

    @Override
    public void visitBegin(SequenceVariableDefExp node, AstVisitorArgs args) throws Exception {
        stack.push(StateType.SEQ, node.getType());
    }

    @Override
    public void visitEnd(SequenceVariableDefExp node) throws Exception {
        stack.pop();
    }

    @Override
    public void visitBegin(SequenceVariableExp node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.SEQ) {
            symbol.registerSequenceVariable(state.getToken().toString(), node.getId().toString());
            args.disableVisitChildren();
            args.disableVisitEnd();
        } else if (state.getType() == StateType.COND) {
            if (tree.isEmptyFunc()) {
                tree.setFunc(new RtValidFunc());
            }
            tree.push(new RtVar(ValType.SEQUENCE,
                    symbol.query(String.valueOf(node.getId().getValue()), ValType.SEQUENCE)));
            stackExp.push(StateType.SEQ);
        }
    }

    @Override
    public void visitEnd(SequenceVariableExp node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            tree.pop();
            stackExp.pop();
        }
    }

    @Override
    public void visitBegin(ArgumentVariableDefExp node, AstVisitorArgs args) throws Exception {
        stack.push(StateType.ARG, node.getType());
    }

    @Override
    public void visitEnd(ArgumentVariableDefExp node) throws Exception {
        stack.pop();
    }

    @Override
    public void visitBegin(ArgumentVariableExp node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.ARG) {
            stack.push(StateType.ARG, node.getId());
            if (state.getType() == StateType.ARG) {
                symbol.registerArgumentVariable(state.getToken().toString(), node.getId().toString());
            }
        } else if (state.getType() == StateType.COND) {
            String name = String.valueOf(node.getId().getValue());
            if (tree.isEmptyFunc() && RtFuncFactory.getInstance().contains(name)) {
                if (!tree.empty()) {
                    throw new SemanticException(name, "函数调用应是单独的语句",
                            SemanticException.SemanticErrorType.ETOKEN);
                }
                tree.setFunc(RtFuncFactory.getInstance().createFunc(name));
                tree.push(new RtVar(ValType.FUNC,
                        RtFuncFactory.getInstance().getTypeIndex(name)
                ));
            } else {
                if (tree.isEmptyFunc()) {
                    tree.setFunc(new RtValidFunc());
                }
                tree.push(new RtVar(ValType.ARGUMENT,
                        symbol.query(name, ValType.ARGUMENT)
                ));
            }
            stackExp.push(StateType.ARG);
        }
    }

    @Override
    public void visitEnd(ArgumentVariableExp node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.ARG) {
            stack.pop(StateType.ARG);
        } else if (state.getType() == StateType.COND) {
            tree.pop();
            stackExp.pop();
        }
    }

    @Override
    public void visitBegin(Sinop node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            if (tree.isEmptyFunc()) {
                tree.setFunc(new RtValidFunc());
            }
            tree.push(new RtSop(node.getType()));
        }
    }

    @Override
    public void visitEnd(Sinop node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            RtSop sop = (RtSop) tree.current();
            if (sop.getChilren().size() != 1) {
                throw new RuntimeException();
            }
            tree.pop();
        }
    }

    @Override
    public void visitBegin(Binop node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            if (tree.isEmptyFunc()) {
                tree.setFunc(new RtValidFunc());
            }
            tree.push(new RtBop(node.getType()));
        }
    }

    @Override
    public void visitEnd(Binop node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            RtBop bop = (RtBop) tree.current();
            if (bop.getChilren().size() != 2) {
                throw new RuntimeException();
            }
            tree.pop();
            if (tree.empty()
                    && node.getType() == OpType.EQ
                    && bop.getChilren().get(0) instanceof RtVar
                    && bop.getChilren().get(1) instanceof RtTExp) {
                RtExp var = bop.getChilren().get(0);
                if (((RtVar) bop.getChilren().get(0)).getType() != ValType.ARGUMENT) {
                    return;
                }
                for (RtExp exp : var.getChilren().get(0).getChilren()) {
                    if (!(exp instanceof RtTExp)) {
                        return;
                    }
                }
                RtValidFunc func = (RtValidFunc) tree.getFunc();
                func.setQuick(true);
            }
        }
    }

    @Override
    public void visitBegin(TokenExp node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.ARG) {
            symbol.registerArgumentVariableType(node.getToken().toString(), state.getToken().toString());
            args.disableVisitChildren();
            args.disableVisitEnd();
        } else if (state.getType() == StateType.COND) {
            if (tree.isEmptyFunc()) {
                throw new SemanticException(node.toString(), "表达式为永真或永假",
                        SemanticException.SemanticErrorType.ETOKEN);
            }
        }
    }

    @Override
    public void visitEnd(TokenExp node) throws Exception {

    }

    @Override
    public void visitBegin(QuantifierExp node, AstVisitorArgs args) throws Exception {
        if (tree.isEmptyFunc()) {
            tree.setFunc(new RtValidFunc());
        }
        symbol.registerTmpVar(String.valueOf(node.getId().getValue()));
        RtValidFunc valid = (RtValidFunc) tree.getFunc();
        valid.add(node.getQuantifier(),
                symbol.query(String.valueOf(node.getType().getValue()), ValType.SET),
                symbol.query(String.valueOf(node.getId().getValue()), ValType.TMPID));
    }

    @Override
    public void visitEnd(QuantifierExp node) throws Exception {
    }

    @Override
    public void visitBegin(TId node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.COND) {
            if (tree.isEmptyFunc()) {
                tree.setFunc(new RtValidFunc());
            }
            switch (stackExp.top().getType()) {
                case NONE:
                case PARAM:
                    ValType[] types = new ValType[]{
                            ValType.SINGLE,
                            ValType.TMPID,
                    };
                    int id = symbol.query(String.valueOf(node.getValue()), types);
                    tree.current().add(new RtVar(types[0], id));
                    break;
            }
        }
    }

    @Override
    public void visitEnd(TId node) throws Exception {

    }

    @Override
    public void visitBegin(TLiteral node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.SET) {
            symbol.registerTypeValue(stack.top().getToken().toString(), node.getValue());
        } else if (state.getType() == StateType.COND) {
            symbol.registerLiteral(String.valueOf(node.getValue()));
            tree.current().add(new RtTExp(new RtTString(symbol.query(String.valueOf(node.getValue()),
                    ValType.LITERAL))));
        }
    }

    @Override
    public void visitEnd(TLiteral node) throws Exception {

    }

    @Override
    public void visitBegin(TNumber node) throws Exception {
        RtStack.StateStruct state = stack.top();
        if (state.getType() == StateType.SET) {
            symbol.registerTypeValue(stack.top().getToken().toString(), node.getValue());
        } else if (state.getType() == StateType.COND) {
            symbol.registerLiteral(String.valueOf(node.getValue()));
            int index = (int) node.getValue();
            tree.current().check(symbol, new Object[]{index});
            tree.current().add(new RtTExp(new RtTNumber(index)));
        }
    }

    @Override
    public void visitEnd(TNumber node) throws Exception {

    }

    @Override
    public void visitBegin(TRange node) throws Exception {
        if (stack.top().getType() == StateType.SET) {
            int lower = node.getLower();
            int upper = node.getUpper();
            if (lower >= upper) {
                throw new SemanticException(node.toString(), "数字范围错误",
                        SemanticException.SemanticErrorType.ERANGE);
            }
            for (int i = lower; i <= upper; i++) {
                symbol.registerTypeValue(stack.top().getToken().toString(), i);
            }
        }
    }

    @Override
    public void visitEnd(TRange node) throws Exception {

    }

    public enum StateType {
        NONE,
        SET,
        SIN,
        SEQ,
        ARG,
        COND,
        PARAM,
        QUAN,
    }
}
