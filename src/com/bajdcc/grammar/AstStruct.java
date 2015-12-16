package com.bajdcc.grammar;

import com.bajdcc.ast.block.IBlock;
import com.bajdcc.ast.exp.IExp;
import com.bajdcc.ast.stmt.IStmt;
import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 兼容结构
 */
public class AstStruct {

    private IExp exp;
    private IToken token;
    private IStmt stmt;
    private IBlock block;

    public AstStruct(@NotNull IExp exp) {
        this.exp = exp;
    }

    public AstStruct(@NotNull IToken token) {
        this.token = token;
    }

    public AstStruct(@NotNull IStmt stmt) {
        this.stmt = stmt;
    }

    public AstStruct(@NotNull IBlock block) {
        this.block = block;
    }

    public
    @NotNull
    IExp getExp() {
        return exp;
    }

    public
    @NotNull
    IToken getToken() {
        return token;
    }

    public
    @NotNull
    IStmt getStmt() {
        return stmt;
    }

    public
    @NotNull
    IBlock getBlock() {
        return block;
    }
}
