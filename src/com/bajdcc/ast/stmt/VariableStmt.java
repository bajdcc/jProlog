package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;

/**
 * 变量
 */
public class VariableStmt extends Stmt implements IVariableStmt {

    public VariableStmt(IExp exp) {
        super(exp);
    }
}
