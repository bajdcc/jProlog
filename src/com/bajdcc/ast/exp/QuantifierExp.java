package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 量词
 */
public class QuantifierExp extends Exp implements IAstComponent {

    private final QuantifierType quantifier;
    private final IToken type;
    private final IToken id;

    public QuantifierExp(@NotNull QuantifierType quantifier, @NotNull IToken type, @NotNull IToken id) {
        this.quantifier = quantifier;
        this.type = type;
        this.id = id;
    }

    public QuantifierType getQuantifier() {
        return quantifier;
    }

    public IToken getType() {
        return type;
    }

    public IToken getId() {
        return id;
    }

    @Override
    public String toString() {
        if (quantifier == QuantifierType.EXISTENTIAL) {
            return String.format("存在 %s 属于 %s, ", id, type);
        } else {
            return String.format("任意 %s 属于 %s, ", id, type);
        }
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            type.visit(visitor);
            id.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }

    public enum QuantifierType {
        EXISTENTIAL,
        UNIVERSAL
    }
}
