package com.bajdcc.ast.token;

import com.bajdcc.visit.IAstComponent;

/**
 * 左值类型
 */
public interface IToken extends IAstComponent {

    /**
     * @return 是否有效
     */
    boolean isValid();
}
