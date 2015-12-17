package com.bajdcc.rt;

import com.bajdcc.ast.block.Block;
import com.bajdcc.ast.exp.*;
import com.bajdcc.ast.stmt.*;
import com.bajdcc.ast.token.TId;
import com.bajdcc.ast.token.TLiteral;
import com.bajdcc.ast.token.TNumber;
import com.bajdcc.ast.token.TRange;
import com.bajdcc.rt.symbol.RtSymbol;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstVisitor;

import java.util.List;

/**
 * 重构AST
 */
public class RtBlock implements IAstVisitor {

    private boolean init = true;
    private RtBlockOriginStruct origin;
    private RtStack stack;
    private RtSymbol symbol;

    public RtBlock() {
        origin = new RtBlockOriginStruct();
        stack = new RtStack();
        symbol = new RtSymbol();
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
            args.setVisitChildren(false);
            args.setVisitEnd(false);
            origin.getSet().add(node);
        }
    }

    @Override
    public void visitEnd(CollectionStmt node) throws Exception {

    }

    @Override
    public void visitBegin(ConditionStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.setVisitChildren(false);
            args.setVisitEnd(false);
            origin.getCond().add(node);
        }
    }

    @Override
    public void visitEnd(ConditionStmt node) throws Exception {

    }

    @Override
    public void visitBegin(SingleVariableStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.setVisitChildren(false);
            args.setVisitEnd(false);
            origin.getSin().add(node);
        }
    }

    @Override
    public void visitEnd(SingleVariableStmt node) throws Exception {

    }

    @Override
    public void visitBegin(SequenceVariableStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.setVisitChildren(false);
            args.setVisitEnd(false);
            origin.getSeq().add(node);
        }
    }

    @Override
    public void visitEnd(SequenceVariableStmt node) throws Exception {

    }

    @Override
    public void visitBegin(ArgumentVariableStmt node, AstVisitorArgs args) throws Exception {
        if (init) {
            args.setVisitChildren(false);
            args.setVisitEnd(false);
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

    }

    @Override
    public void visitEnd(ArgumentExp node) throws Exception {

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
            args.setVisitChildren(false);
            args.setVisitEnd(false);
        }
    }

    @Override
    public void visitEnd(SingleVariableExp node) throws Exception {

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
            args.setVisitChildren(false);
            args.setVisitEnd(false);
        }
    }

    @Override
    public void visitEnd(SequenceVariableExp node) throws Exception {

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
        }
    }

    @Override
    public void visitEnd(ArgumentVariableExp node) throws Exception {
        stack.pop(StateType.ARG);
    }

    @Override
    public void visitBegin(Sinop node, AstVisitorArgs args) throws Exception {

    }

    @Override
    public void visitEnd(Sinop node) throws Exception {

    }

    @Override
    public void visitBegin(Binop node, AstVisitorArgs args) throws Exception {

    }

    @Override
    public void visitEnd(Binop node) throws Exception {

    }

    @Override
    public void visitBegin(TokenExp node, AstVisitorArgs args) throws Exception {
        RtStack.StateStruct state = stack.top();
        switch (state.getType()) {
            case SEQ:
                symbol.registerTypeValue(state.getToken().toString(), node.getToken());
                args.setVisitChildren(false);
                args.setVisitEnd(false);
                break;
            case ARG:
                symbol.registerArgumentVariableType(state.getToken().toString(), node.getToken().toString());
                args.setVisitChildren(false);
                args.setVisitEnd(false);
                break;
        }
    }

    @Override
    public void visitEnd(TokenExp node) throws Exception {

    }

    @Override
    public void visitBegin(QuantifierExp node, AstVisitorArgs args) throws Exception {

    }

    @Override
    public void visitEnd(QuantifierExp node) throws Exception {

    }

    @Override
    public void visitBegin(TId node) throws Exception {

    }

    @Override
    public void visitEnd(TId node) throws Exception {

    }

    @Override
    public void visitBegin(TLiteral node) throws Exception {

    }

    @Override
    public void visitEnd(TLiteral node) throws Exception {

    }

    @Override
    public void visitBegin(TNumber node) throws Exception {

    }

    @Override
    public void visitEnd(TNumber node) throws Exception {

    }

    @Override
    public void visitBegin(TRange node) throws Exception {

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
    }
}
