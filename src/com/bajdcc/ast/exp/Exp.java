package com.bajdcc.ast.exp;

import com.sun.istack.internal.NotNull;

/**
 * 表达式
 */
public abstract class Exp implements IExp {

    @Override
    public void addChild(@NotNull IExp exp) {
    }

    @Override
    public IVariableExp getVariable() {
        return null;
    }

    @Override
    public boolean isToken() {
        return true;
    }
}
