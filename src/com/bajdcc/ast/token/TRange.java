package com.bajdcc.ast.token;

import com.sun.istack.internal.NotNull;

/**
 * 范围
 */
public class TRange implements IToken {

    private int lower;
    private int upper;

    public TRange(@NotNull String lower, @NotNull String upper) {
        this.lower = Integer.parseInt(lower);
        this.upper = Integer.parseInt(upper);
    }

    @Override
    public String toString() {
        return String.format("%d:%d", lower, upper);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
