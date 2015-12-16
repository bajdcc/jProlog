package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 集合
 */
public class CollectionExp extends Exp {

    private IToken type;
    private IExp argument;

    public CollectionExp(@NotNull IToken type, @NotNull IExp argument) {
        this.type = type;
        this.argument = argument;
    }

    @Override
    public String toString() {
        return String.format("%s = { %s }", type, argument);
    }
}
