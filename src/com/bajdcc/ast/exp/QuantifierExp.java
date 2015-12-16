package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 量词
 */
public class QuantifierExp extends Exp {

    private QuantifierType quantifier;
    private IToken type;
    private IToken id;

    public QuantifierExp(@NotNull QuantifierType quantifier, @NotNull IToken type, @NotNull IToken id) {
        this.quantifier = quantifier;
        this.type = type;
        this.id = id;
    }

    @Override
    public String toString() {
        if (quantifier == QuantifierType.EXISTENTIAL) {
            return String.format("存在 %s %s, ", type, id);
        } else {
            return String.format("所有 %s %s, ", type, id);
        }
    }

    public enum QuantifierType {
        EXISTENTIAL,
        UNIVERSAL
    }
}
