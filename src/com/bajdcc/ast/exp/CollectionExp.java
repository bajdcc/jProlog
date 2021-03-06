package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 集合
 */
public class CollectionExp extends Exp implements IAstComponent {

    private final IToken type;
    private final IExp argument;

    public CollectionExp(@NotNull IToken type, @NotNull IExp argument) {
        this.type = type;
        this.argument = argument;
    }

    public IToken getType() {
        return type;
    }

    public IExp getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return String.format("%s{} = { %s }", type, argument);
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            argument.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
