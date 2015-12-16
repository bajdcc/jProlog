package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 字符表达式
 */
public class TokenExp extends Exp {

    private IToken token;

    public TokenExp(@NotNull IToken token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token.toString();
    }
}
