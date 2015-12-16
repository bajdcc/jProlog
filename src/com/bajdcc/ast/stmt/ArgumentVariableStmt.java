package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;

/**
 * 参变量
 */
public class ArgumentVariableStmt extends VariableStmt {

    public ArgumentVariableStmt(IExp exp) {
        super(exp);
    }
}
