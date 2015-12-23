package com.bajdcc.ast.exp;

import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 单目表达式
 */
public class Sinop extends Exp implements IAstComponent {

    private OpType type;
    private IExp exp;

    public OpType getType() {
        return type;
    }

    public void setType(@NotNull OpType type) {
        this.type = type;
    }

    public IExp getExp() {
        return exp;
    }

    public void setExp(IExp exp) {
        this.exp = exp;
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
        return String.format("%s %s",
                exp.isToken() ? exp : ("(" + exp + ")"),
                type.getName());
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            exp.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
