package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 序变量定义
 */
public class SequenceVariableDefExp extends VariableExp {

    private IToken type;
    private IExp ids;

    public SequenceVariableDefExp(@NotNull IToken type, @NotNull IExp ids) {
        this.type = type;
        this.ids = ids;
    }

    public IExp setType(@NotNull IToken type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s", type, ids);
    }
}
