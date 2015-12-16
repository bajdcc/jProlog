package com.bajdcc.ast.block;

import com.bajdcc.ast.stmt.IStmt;

/**
 * 块
 */
public interface IBlock {

    void addChild(IStmt stmt);
}
