package com.bajdcc.ast.exp;

import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 参数表达式
 */
public class ArgumentExp extends Exp implements IAstComponent {

    private final List<IExp> arguments = new ArrayList<>();

    public List<IExp> getArguments() {
        return arguments;
    }

    @Override
    public void addChild(@NotNull IExp exp) {
        this.arguments.add(exp);
    }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ");
        for (IExp argument : arguments) {
            sj.add(argument.toString());
        }
        return sj.toString();
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            for (IExp argument : arguments) {
                argument.visit(visitor);
            }
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
