package com.bajdcc.ast.token;

import com.sun.istack.internal.NotNull;

/**
 * 字面量
 */
public class TLiteral implements IToken {

    private String literal;

    public TLiteral(@NotNull String literal) {
        this.literal = literal.substring(1, literal.length() - 1);
    }

    @Override
    public String toString() {
        return String.format("\"%s\"", literal);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
