package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;

/**
 * 单变量
 */
public class SingleVariableStmt extends VariableStmt {

    public SingleVariableStmt(IExp exp) {
        super(exp);
    }

}
