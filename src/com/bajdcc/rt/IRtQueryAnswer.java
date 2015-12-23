package com.bajdcc.rt;

import com.bajdcc.rt.error.SemanticException;
import com.sun.istack.internal.NotNull;

/**
 * 查询结果
 */
public interface IRtQueryAnswer {

    /**
     * 获取值
     *
     * @param id     第几个结果
     * @param var    变量名
     * @param params 参数
     * @return 值，为{@link Integer}或{@link String}
     */
    @NotNull
    Object queryValue(int id, @NotNull String var, Object[] params) throws SemanticException;
}
