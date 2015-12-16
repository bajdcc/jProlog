package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 序变量
 */
public class SequenceVariableExp extends VariableExp {

    private IToken id;
    private IToken index;

    public SequenceVariableExp(@NotNull IToken id, @NotNull IToken index) {
        this.id = id;
        this.index = index;
    }

    @Override
    public String toString() {
        if (index.isValid()) {
            return String.format("%s[%s]", id, index);
        } else {
            return String.format("%s[]", id);
        }
    }
}
