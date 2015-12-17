package com.bajdcc.ast.block;

import com.bajdcc.ast.stmt.IStmt;
import com.bajdcc.visit.IAstComponent;
import com.sun.istack.internal.NotNull;

/**
 * 块
 */
public interface IBlock extends IAstComponent {

    void addChild(@NotNull IStmt stmt);
}
