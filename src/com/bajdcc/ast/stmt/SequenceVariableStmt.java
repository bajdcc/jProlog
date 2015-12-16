package com.bajdcc.ast.stmt;

import com.bajdcc.ast.exp.IExp;

/**
 * 序变量
 */
public class SequenceVariableStmt extends VariableStmt {

    public SequenceVariableStmt(IExp exp) {
        super(exp);
    }
}
