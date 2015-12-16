package com.bajdcc.grammar;

import com.bajdcc.ast.block.Block;
import com.bajdcc.ast.exp.*;
import com.bajdcc.ast.stmt.*;
import com.bajdcc.ast.token.TId;
import com.bajdcc.ast.token.TLiteral;
import com.bajdcc.ast.token.TNumber;
import com.bajdcc.ast.token.TRange;

/**
 * 生成语法树
 */
public class PrologBaseVisitorImpl extends PrologBaseVisitor<AstStruct> {
    @Override
    public AstStruct visitStart(PrologParser.StartContext ctx) {
        return new AstStruct(visit(ctx.definitions()).getBlock());
    }

    @Override
    public AstStruct visitDefinitions(PrologParser.DefinitionsContext ctx) {
        Block block = new Block();
        for (PrologParser.DefinitionContext context : ctx.definition()) {
            block.addChild(visit(context).getStmt());
        }
        return new AstStruct(block);
    }

    @Override
    public AstStruct visitDefinition(PrologParser.DefinitionContext ctx) {
        if (ctx.setDef() != null) {
            return new AstStruct(visit(ctx.setDef()).getStmt());
        } else if (ctx.variableDef() != null) {
            return new AstStruct(visit(ctx.variableDef()).getStmt());
        } else {
            return new AstStruct(visit(ctx.conditionDef()).getStmt());
        }
    }

    @Override
    public AstStruct visitSetDef(PrologParser.SetDefContext ctx) {
        return new AstStruct(
                new CollectionStmt(
                        new CollectionExp(
                                new TId(ctx.type.getText()),
                                visit(ctx.setParams()).getExp()
                        )
                )
        );
    }

    @Override
    public AstStruct visitSetParams(PrologParser.SetParamsContext ctx) {
        ArgumentExp exp = new ArgumentExp();
        for (PrologParser.SetParamContext context : ctx.setParam()) {
            exp.addChild(new TokenExp(visit(context).getToken()));
        }
        return new AstStruct(exp);
    }

    @Override
    public AstStruct visitSetParam(PrologParser.SetParamContext ctx) {
        if (ctx.string != null) {
            return new AstStruct(
                    new TLiteral(ctx.string.getText())
            );
        } else if (ctx.num != null) {
            return new AstStruct(
                    new TNumber(ctx.num.getText())
            );
        } else {
            return new AstStruct(
                    new TRange(ctx.lower.getText(), ctx.upper.getText())
            );
        }
    }

    @Override
    public AstStruct visitVariableDef(PrologParser.VariableDefContext ctx) {
        if (ctx.vDef1() != null) {
            return new AstStruct(
                    new SingleVariableStmt(
                            new SingleVariableDefExp(
                                    new TId(ctx.type.getText()),
                                    visit(ctx.vDef1()).getExp())
                    ));
        } else if (ctx.vDef2() != null) {
            return new AstStruct(
                    new SequenceVariableStmt(
                            new SequenceVariableDefExp(
                                    new TId(ctx.type.getText()),
                                    visit(ctx.vDef2()).getExp())
                    ));
        } else {
            return new AstStruct(
                    new ArgumentVariableStmt(
                            new ArgumentVariableDefExp(
                                    new TId(ctx.type.getText()),
                                    visit(ctx.vDef3()).getExp())
                    ));
        }
    }

    @Override
    public AstStruct visitVDef1(PrologParser.VDef1Context ctx) {
        ArgumentExp exp = new ArgumentExp();
        for (int i = 0; i < ctx.ID().size(); i++) {
            exp.addChild(
                    new SingleVariableExp(
                            new TId(ctx.ID(i).getText())));
        }
        return new AstStruct(exp);
    }

    @Override
    public AstStruct visitVDef2(PrologParser.VDef2Context ctx) {
        ArgumentExp exp = new ArgumentExp();
        for (int i = 0; i < ctx.ID().size(); i++) {
            exp.addChild(
                    new SequenceVariableExp(
                            new TId(ctx.ID(i).getText()),
                            TNumber.INVALID));
        }
        return new AstStruct(exp);
    }

    @Override
    public AstStruct visitVDef3(PrologParser.VDef3Context ctx) {
        ArgumentExp exp = new ArgumentExp();
        for (int i = 0; i < ctx.ID().size(); i++) {
            exp.addChild(
                    new ArgumentVariableExp(
                            new TId(ctx.ID(i).getText()),
                            visit(ctx.typeParams(i)).getExp()));
        }
        return new AstStruct(exp);
    }

    @Override
    public AstStruct visitTypeParams(PrologParser.TypeParamsContext ctx) {
        ArgumentExp exp = new ArgumentExp();
        for (int i = 0; i < ctx.ID().size(); i++) {
            exp.addChild(new TokenExp(new TId(ctx.ID(i).getText())));
        }
        return new AstStruct(exp);
    }

    @Override
    public AstStruct visitConditionDef(PrologParser.ConditionDefContext ctx) {
        if (ctx.quantifiers() != null) {
            return new AstStruct(new ConditionStmt(
                    visit(ctx.quantifiers()).getExp(),
                    visit(ctx.expression()).getExp()));
        } else {
            return new AstStruct(new ConditionStmt(
                    visit(ctx.expression()).getExp()));
        }
    }

    @Override
    public AstStruct visitQuantifiers(PrologParser.QuantifiersContext ctx) {
        ArgumentExp exp = new ArgumentExp();
        for (PrologParser.QuantifierContext context : ctx.quantifier()) {
            exp.addChild(visit(context).getExp());
        }
        return new AstStruct(exp);
    }

    @Override
    public AstStruct visitQuantifier(PrologParser.QuantifierContext ctx) {
        return new AstStruct(
                new QuantifierExp(ctx.Existential() != null ?
                        QuantifierExp.QuantifierType.EXISTENTIAL :
                        QuantifierExp.QuantifierType.UNIVERSAL,
                        new TId(ctx.type.getText()),
                        new TId(ctx.id.getText())));
    }

    @Override
    public AstStruct visitParameters(PrologParser.ParametersContext ctx) {
        ArgumentExp exp = new ArgumentExp();
        for (PrologParser.ExpressionContext context : ctx.expression()) {
            exp.addChild(visit(context).getExp());
        }
        return new AstStruct(exp);
    }

    @Override
    public AstStruct visitExpression(PrologParser.ExpressionContext ctx) {
        if (ctx.bop != null) { //bop
            String bop = ctx.bop.getText();
            Binop op = new Binop();
            boolean single = bop.length() == 1;
            switch (bop.charAt(0)) {
                case '=':
                    op.setType(OpType.EQ);
                    break;
                case '!':
                    op.setType(OpType.NEQ);
                    break;
                case '<':
                    op.setType(single ? OpType.LT : (bop.charAt(1) == '>' ? OpType.NEQ : OpType.LTE));
                    break;
                case '>':
                    op.setType(single ? OpType.GT : OpType.GTE);
                    break;
                case '-':
                    op.setType(single ? OpType.MINUS : OpType.IMPLY);
                    break;
                case '|':
                    op.setType(OpType.OR);
                    break;
                case '&':
                    op.setType(OpType.AND);
                    break;
                case '^':
                    op.setType(OpType.XOR);
                    break;
                case '+':
                    op.setType(OpType.PLUS);
                    break;
                case '*':
                    op.setType(OpType.MUL);
                    break;
                case '/':
                    op.setType(OpType.DIV);
                    break;
                case '%':
                    op.setType(OpType.MOD);
                    break;
            }
            op.setExp1(visit(ctx.expression(0)).getExp());
            op.setExp2(visit(ctx.expression(1)).getExp());
            return new AstStruct(op);
        } else if (ctx.uop != null) {
            String sop = ctx.uop.getText();
            Sinop op = new Sinop();
            switch (sop.charAt(0)) {
                case '~':
                case '!':
                    op.setType(OpType.NOT);
                    break;
            }
            op.setExp(visit(ctx.expression(0)).getExp());
            return new AstStruct(op);
        } else {
            int cc = ctx.getChildCount();
            if (cc == 1) {
                if (ctx.ID() != null) {
                    return new AstStruct(
                            new TokenExp(
                                    new TId(ctx.ID().getText())));
                } else if (ctx.Literal() != null) {
                    return new AstStruct(
                            new TokenExp(
                                    new TLiteral(ctx.Literal().getText())));
                } else if (ctx.Number() != null) {
                    return new AstStruct(
                            new TokenExp(
                                    new TNumber(ctx.Number().getText())));
                }
            } else if (cc == 3) {
                return new AstStruct(visit(ctx.expression(0)).getExp());
            } else if (cc == 4) {
                if (ctx.Number() != null) {
                    return new AstStruct(
                            new SequenceVariableExp(
                                    new TId(ctx.ID().getText()),
                                    new TNumber(ctx.Number().getText())));
                } else {
                    return new AstStruct(
                            new ArgumentVariableExp(
                                    new TId(ctx.ID().getText()),
                                    visit(ctx.parameters()).getExp()));
                }
            }
        }
        throw new RuntimeException();
    }
}
