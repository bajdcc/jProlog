package com.bajdcc.ast.block;

import com.bajdcc.ast.stmt.IStmt;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 块
 */
public class Block implements IBlock {

    private List<IStmt> stmts = new ArrayList<>();

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
}
