package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 单变量
 */
public class SingleVariableExp extends VariableExp {

    private IToken id;

    public SingleVariableExp(@NotNull IToken id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
