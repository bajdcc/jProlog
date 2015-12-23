package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 单变量
 */
public class SingleVariableExp extends VariableExp implements IAstComponent {

    private final IToken id;

    public SingleVariableExp(@NotNull IToken id) {
        this.id = id;
    }

    public IToken getId() {
        return id;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            id.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
