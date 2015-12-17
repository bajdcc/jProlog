package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 逻辑表达式语句
 */
public class ConditionStmt extends Stmt implements IAstComponent {

    private IExp quantifiers;

    public ConditionStmt(@NotNull IExp exp) {
        super(exp);
    }

    public ConditionStmt(@NotNull IExp exp, @NotNull IExp quantifiers) {
        super(exp);
        this.quantifiers = quantifiers;
    }

    @Override
    public String toString() {
        if (quantifiers != null) {
            return String.format("%s%s", quantifiers, super.toString());
        } else {
            return super.toString();
        }
    }

    @Override
    public void visit(IAstVisitor visitor) {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            quantifiers.visit(visitor);
            exp.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
