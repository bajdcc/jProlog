package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 变量表达式
 */
public abstract class VariableExp extends Exp implements IVariableExp {

    @Override
    public
    @NotNull
    IVariableExp getVariable() {
        return this;
    }

    @Override
    public IExp setType(@NotNull IToken type) {
        return null;
    }
}
