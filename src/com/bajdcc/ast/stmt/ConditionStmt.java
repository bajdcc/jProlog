package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;
import com.sun.istack.internal.NotNull;

/**
 * 逻辑表达式语句
 */
public class ConditionStmt extends Stmt {

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
}
