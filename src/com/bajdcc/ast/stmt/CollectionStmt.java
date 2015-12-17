package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;

/**
 * 定义集合
 */
public class CollectionStmt extends Stmt implements IAstComponent {

    public CollectionStmt(IExp exp) {
        super(exp);
    }

    @Override
    public void visit(IAstVisitor visitor) {
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
