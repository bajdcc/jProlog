package com.bajdcc.ast.token;

import com.sun.istack.internal.NotNull;

/**
 * 数字
 */
public class TNumber implements IToken {

    public static final TNumber INVALID = new TNumber("-1");

    private int number;

    public TNumber(@NotNull String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean isValid() {
        return number != -1;
    }
}
