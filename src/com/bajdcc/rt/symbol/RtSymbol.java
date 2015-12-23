package com.bajdcc.rt.symbol;

import com.bajdcc.rt.RtBlockAdvanceStruct;
import com.bajdcc.rt.adv.*;
import com.bajdcc.rt.error.SemanticException;

/**
 * 符号表
 */
public class RtSymbol {

    private final RtStringFactory strFactory = new RtStringFactory();
    private final RtBlockAdvanceStruct adv = new RtBlockAdvanceStruct();

    public RtStringFactory getStrFactory() {
        return strFactory;
    }

    public RtBlockAdvanceStruct getAdv() {
        return adv;
    }

    /**
     * 注册类型
     *
     * @param type 类型名
     * @throws SemanticException 类型名重复
     */
    public void registerType(String type) throws SemanticException {
        if (!strFactory.add(type, ValType.SET)) {
            throw new SemanticException(type, "集合名重复定义", SemanticException.SemanticErrorType.REDECL);
        }
        adv.addSet(new RtSetDef(strFactory.query(type, ValType.SET)));
    }

    /**
     * 注册类型的值
     *
     * @param type  类型名
     * @param value 类型值，类型可以为{@link java.lang.String}或{@link java.lang.Integer}
     * @throws SemanticException 类型名重复，或者类型不一致
     */
    public void registerTypeValue(String type, Object value) throws SemanticException {
        RtSetDef set = adv.getSet(strFactory.query(type, ValType.SET));
        String val = String.valueOf(value);
        if (value instanceof Integer) {
            set.addInteger(Integer.parseInt(val));
        } else {
            strFactory.add(val, ValType.LITERAL);
            set.addLiteral(strFactory.query(val, ValType.LITERAL));
        }
    }

    /**
     * 注册单变量
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在，或者变量名重复
     */
    public void registerSingleVariable(String type, String var) throws SemanticException {
        int id = strFactory.query(type, ValType.SET);
        if (strFactory.containsVar(var)) {
            throw new SemanticException(var, "单变量重复定义", SemanticException.SemanticErrorType.REDECL);
        }
        strFactory.add(var, ValType.SINGLE);
        adv.addSin(new RtSinVarDef(strFactory.query(var, ValType.SINGLE), id));
    }

    /**
     * 注册序变量
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在，或者变量名重复
     */
    public void registerSequenceVariable(String type, String var) throws SemanticException {
        int id = strFactory.query(type, ValType.SET);
        if (strFactory.containsVar(var)) {
            throw new SemanticException(var, "序变量重复定义", SemanticException.SemanticErrorType.REDECL);
        }
        strFactory.add(var, ValType.SEQUENCE);
        adv.addSeq(new RtSeqVarDef(strFactory.query(var, ValType.SEQUENCE), id));
    }

    /**
     * 注册参变量
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在，或者变量名重复
     */
    public void registerArgumentVariable(String type, String var) throws SemanticException {
        int id = strFactory.query(type, ValType.SET);
        if (strFactory.containsVar(var)) {
            throw new SemanticException(var, "参变量重复定义", SemanticException.SemanticErrorType.REDECL);
        }
        strFactory.add(var, ValType.ARGUMENT);
        adv.addArg(new RtArgVarDef(strFactory.query(var, ValType.ARGUMENT), id));
    }

    /**
     * 注册参变量参数类型
     *
     * @param type 类型名
     * @param var  变量名
     * @throws SemanticException 类型名不存在，或者变量名不存在
     */
    public void registerArgumentVariableType(String type, String var) throws SemanticException {
        RtArgVarDef arg = adv.getArg(strFactory.query(var, ValType.ARGUMENT));
        arg.add(strFactory.query(type, ValType.SET));
    }

    /**
     * 注册字面量
     *
     * @param literal 字串
     * @throws SemanticException
     */
    public void registerLiteral(String literal) throws SemanticException {
        strFactory.add(literal, ValType.LITERAL);
    }

    /**
     * 注册临时变量
     *
     * @param var 变量名
     * @throws SemanticException 变量名冲突
     */
    public void registerTmpVar(String var) throws SemanticException {
        if (strFactory.containsVar(var)) {
            throw new SemanticException(var, "变量名重复定义", SemanticException.SemanticErrorType.REDECL);
        }
        strFactory.add(var, ValType.TMPID);
    }

    /**
     * 查询字串ID
     *
     * @param str 字串
     * @param val 字串类型
     * @return ID
     * @throws SemanticException 字串不存在
     */
    public int query(String str, ValType val) throws SemanticException {
        return strFactory.query(str, val);
    }

    /**
     * 查询字串ID
     *
     * @param str 字串
     * @param val 字串类型数组
     * @return ID
     * @throws SemanticException 字串不存在
     */
    public int query(String str, ValType[] val) throws SemanticException {
        return strFactory.query(str, val);
    }

    /**
     * 注册函数
     *
     * @param func 函数
     * @throws SemanticException
     */
    public void registerFunc(RtFunc func) throws SemanticException {
        adv.addFunc(func);
    }
}
