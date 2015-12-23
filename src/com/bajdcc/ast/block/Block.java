package com.bajdcc.ast.block;

import com.bajdcc.ast.stmt.IStmt;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 块
 */
public class Block implements IBlock, IAstComponent {

    private final List<IStmt> stmts = new ArrayList<>();

    public List<IStmt> getStmts() {
        return stmts;
    }

    @Override
    public void addChild(@NotNull IStmt stmt) {
        this.stmts.add(stmt);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(System.getProperty("line.separator"));
        for (IStmt stmt : stmts) {
            sj.add(stmt.toString());
        }
        return sj.toString();
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            for (IStmt stmt : stmts) {
                stmt.visit(visitor);
            }
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
