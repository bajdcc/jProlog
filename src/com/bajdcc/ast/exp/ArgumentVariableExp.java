package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 参变量
 */
public class ArgumentVariableExp extends VariableExp {

    private IToken id;
    private IExp argument;

    public ArgumentVariableExp(@NotNull IToken id, @NotNull IExp argument) {
        this.id = id;
        this.argument = argument;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", id, argument);
    }
}
