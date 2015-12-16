package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

/**
 * 变量使用
 */
public interface IVariableExp {
    IExp setType(@NotNull IToken type);
}
