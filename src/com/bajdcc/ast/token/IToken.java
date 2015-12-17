package com.bajdcc.ast.token;

import com.bajdcc.visit.IAstComponent;
import com.sun.istack.internal.NotNull;

/**
 * 左值类型
 */
public interface IToken extends IAstComponent {

    /**
     * @return 是否有效
     */
    boolean isValid();

    /**
     * @return 类型
     */
    TokenType getType();

    /**
     * @return 取值
     */
    @NotNull
    Object getValue();
}
