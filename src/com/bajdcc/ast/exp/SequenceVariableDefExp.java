package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 序变量定义
 */
public class SequenceVariableDefExp extends VariableExp implements IAstComponent {

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

    public IToken getType() {
        return type;
    }

    public IExp getIds() {
        return ids;
    }

    @Override
    public String toString() {
        return String.format("%s %s", type, ids);
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            type.visit(visitor);
            ids.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
