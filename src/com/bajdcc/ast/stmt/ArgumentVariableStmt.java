package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;

/**
 * 参变量
 */
public class ArgumentVariableStmt extends VariableStmt implements IAstComponent {

    public ArgumentVariableStmt(IExp exp) {
        super(exp);
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            exp.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
