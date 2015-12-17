package com.bajdcc.rt.symbol;

import com.bajdcc.rt.error.SemanticException;

/**
 * 符号表
 */
public class RtSymbol {


    /**
     * 注册类型
     *
     * @param type 类型名
     * @throws SemanticException 类型名重复
     */
    public void registerType(String type) throws SemanticException {
        System.out.println(type);
    }

    /**
     * 注册类型的值
     *
     * @param type  类型名
     * @param value 类型值，类型可以为{@link java.lang.String}或{@link java.lang.Integer}
     * @throws SemanticException 类型名重复，或者类型不一致
     */
    public void registerTypeValue(String type, Object value) throws SemanticException {
        System.out.println(type + " " + value);
    }

    /**
     * 注册单变量
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在，或者变量名重复
     */
    public void registerSingleVariable(String type, String var) throws SemanticException {
        System.out.println(type + " " + var);
    }

    /**
     * 注册序变量
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在，或者变量名重复
     */
    public void registerSequenceVariable(String type, String var) throws SemanticException {
        System.out.println(type + " " + var);
    }

    /**
     * 注册参变量
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在，或者变量名重复
     */
    public void registerArgumentVariable(String type, String var) throws SemanticException {
        System.out.println(type + " " + var);
    }

    /**
     * 注册参变量参数类型
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在
     */
    public void registerArgumentVariableType(String type, String var) throws SemanticException {
        System.out.println(type + " " + var);
    }
}
