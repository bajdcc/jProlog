package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 参变量
 */
public class ArgumentVariableExp extends VariableExp implements IAstComponent {

    private IToken id;
    private IExp argument;

    public ArgumentVariableExp(@NotNull IToken id, @NotNull IExp argument) {
        this.id = id;
        this.argument = argument;
    }

    public IToken getId() {
        return id;
    }

    public IExp getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", id, argument);
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
