package com.bajdcc.ast.exp;

import com.sun.istack.internal.NotNull;

/**
 * 单目表达式
 */
public class Sinop extends Exp {

    private OpType type;
    private IExp exp;

    public void setType(@NotNull OpType type) {
        this.type = type;
    }

    public void setExp(IExp exp) {
        this.exp = exp;
    }

    @Override
    public boolean isToken() {
        return exp.isToken();
    }

    @Override
    public String toString() {
        if (isToken()) {
            return String.format("%s %s", type.getName(), exp);
        } else {
            return String.format("(%s %s)", type.getName(), exp);
        }
    }
}
