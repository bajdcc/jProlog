package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 参变量定义
 */
public class ArgumentVariableDefExp extends VariableExp implements IAstComponent {

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

    @Override
    public void visit(IAstVisitor visitor) {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            ids.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
