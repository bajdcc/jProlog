package com.bajdcc.ast.exp;

import com.sun.istack.internal.NotNull;

/**
 * 双目表达式
 */
public class Binop extends Exp {

    private OpType type;
    private IExp exp1, exp2;

    public void setType(@NotNull OpType type) {
        this.type = type;
    }

    public void setExp1(@NotNull IExp exp1) {
        this.exp1 = exp1;
    }

    public void setExp2(@NotNull IExp exp2) {
        this.exp2 = exp2;
    }

    @Override
    public boolean isToken() {
        return exp1.isToken() && exp2.isToken();
    }

    @Override
    public String toString() {
        if (isToken()) {
            return String.format("%s %s %s", exp1, type.getName(), exp2);
        } else {
            return String.format("(%s %s %s)", exp1, type.getName(), exp2);
        }
    }
}
