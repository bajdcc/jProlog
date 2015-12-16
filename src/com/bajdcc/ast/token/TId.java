package com.bajdcc.ast.token;

import com.sun.istack.internal.NotNull;

/**
 * 变量名
 */
public class TId implements IToken {

    private String id;

    public TId(@NotNull String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}

