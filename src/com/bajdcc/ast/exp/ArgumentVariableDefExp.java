package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 参变量定义
 */
public class ArgumentVariableDefExp extends VariableExp {

    private IToken type;
    private IExp ids;

    public ArgumentVariableDefExp(@NotNull IToken type, @NotNull IExp ids) {
        this.type = type;
        this.ids = ids;
    }

    @Override
    public String toString() {
        return String.format("%s %s", type, ids);
    }
}
