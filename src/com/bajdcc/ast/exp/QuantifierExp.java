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

    @Override
    public void visit(IAstVisitor visitor) {
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
