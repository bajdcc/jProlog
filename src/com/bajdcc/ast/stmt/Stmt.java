package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;
import com.sun.istack.internal.NotNull;

/**
 * 语句
 */
public abstract class Stmt implements IStmt {

    protected final IExp exp;

    public Stmt(@NotNull IExp exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return String.format("%s;", exp);
    }
}
