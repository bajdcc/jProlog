package com.bajdcc.ast.exp;

import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 双目表达式
 */
public class Binop extends Exp implements IAstComponent {

    private OpType type;
    private IExp exp1, exp2;

    public OpType getType() {
        return type;
    }

    public void setType(@NotNull OpType type) {
        this.type = type;
    }

    public IExp getExp1() {
        return exp1;
    }

    public void setExp1(@NotNull IExp exp1) {
        this.exp1 = exp1;
    }

    public IExp getExp2() {
        return exp2;
    }

    public void setExp2(@NotNull IExp exp2) {
        this.exp2 = exp2;
    }

    @Override
    public boolean isToken() {
        return false;
    }

    @Override
    public OpType getOp() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",
                (exp1.isToken() || OpType.gte(exp1.getOp(), type)) ? (exp1) : ("(" + exp1 + ")"),
                type.getName(),
                (exp2.isToken() || OpType.gte(exp2.getOp(), type)) ? (exp2) : ("(" + exp2 + ")"));
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            exp1.visit(visitor);
            exp2.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
