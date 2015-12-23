package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 序变量
 */
public class SequenceVariableExp extends VariableExp implements IAstComponent {

    private final IToken id;
    private final IToken index;

    public SequenceVariableExp(@NotNull IToken id, @NotNull IToken index) {
        this.id = id;
        this.index = index;
    }

    public IToken getId() {
        return id;
    }

    public IToken getIndex() {
        return index;
    }

    @Override
    public String toString() {
        if (index.isValid()) {
            return String.format("%s[%s]", id, index);
        } else {
            return String.format("%s[]", id);
        }
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            id.visit(visitor);
            index.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
