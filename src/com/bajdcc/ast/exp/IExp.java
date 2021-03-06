package com.bajdcc.ast.exp;

import com.bajdcc.visit.IAstComponent;
import com.sun.istack.internal.NotNull;

/**
 * 表达式
 */
public interface IExp extends IAstComponent {

    /**
     * 添加子结点
     *
     * @param exp 子结点
     */
    void addChild(@NotNull IExp exp);

    /**
     * 获取变量接口
     *
     * @return 变量
     */
    @NotNull
    IVariableExp getVariable();

    /**
     * 便于输出时确定没有嵌套表达式
     *
     * @return 是否是左值
     */
    boolean isToken();

    /**
     * @return 操作符
     */
    OpType getOp();
}
