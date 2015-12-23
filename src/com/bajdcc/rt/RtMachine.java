package com.bajdcc.rt;

import com.bajdcc.prolog.PrologExecutor;
import com.bajdcc.rt.adv.*;
import com.bajdcc.rt.adv.exp.RtExp;
import com.bajdcc.rt.adv.exp.RtTExp;
import com.bajdcc.rt.adv.exp.RtVar;
import com.bajdcc.rt.adv.func.RtValidFunc;
import com.bajdcc.rt.adv.token.RtTNumber;
import com.bajdcc.rt.adv.token.RtTString;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.gen.RtGenCenter;
import com.bajdcc.rt.gen.unit.RtGenArgUnit;
import com.bajdcc.rt.gen.unit.RtGenSeqUnit;
import com.bajdcc.rt.gen.unit.RtGenSinUnit;
import com.bajdcc.rt.symbol.RtSymbol;
import com.bajdcc.rt.symbol.ValType;
import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 运行时机器
 */
public class RtMachine implements IRtQueryAnswer {

    private final RtSymbol symbol;
    private final RtBlockAdvanceStruct adv;
    private final boolean debug;
    private final RtEnv env;
    private final RtGenCenter gen;
    private final List<RtEnv> savedEnv;
    private final RtSettings settings;

    public RtMachine(@NotNull RtBlock block, boolean debug) throws SemanticException {
        this.symbol = block.getSymbol();
        this.adv = this.symbol.getAdv();
        this.debug = debug;
        this.env = new RtEnv(this.symbol);
        this.settings = this.env.getSettings();
        this.gen = this.env.getGen();
        this.savedEnv = new ArrayList<>();
        initGenCenter();
        optimizeGenCenter();
        this.env.initFunc();
    }

    private void initGenCenter() throws SemanticException {
        RtBlockAdvanceStruct adv = symbol.getAdv();
        for (Map.Entry<Integer, RtSinVarDef> entry : adv.getSin().entrySet()) {
            RtSetDef set = adv.getSet(entry.getValue().getType());
            gen.addUnit(new RtGenSinUnit(set.getType(), entry.getKey(), set.getElementCount()));
        }
        for (Map.Entry<Integer, RtSeqVarDef> entry : adv.getSeq().entrySet()) {
            RtSetDef set = adv.getSet(entry.getValue().getType());
            gen.addUnit(new RtGenSeqUnit(set.getType(), entry.getKey(), set.getElementCount()));
        }
        for (Map.Entry<Integer, RtArgVarDef> entry : adv.getArg().entrySet()) {
            RtSetDef set = adv.getSet(entry.getValue().getType());
            int size = entry.getValue().getElementCount();
            int[] params = new int[size];
            List<Integer> elements = entry.getValue().getElements();
            for (int i = 0; i < size; i++) {
                params[i] = adv.getSet(elements.get(i)).getElementCount();
            }
            gen.addUnit(new RtGenArgUnit(set.getType(), entry.getKey(), set.getElementCount(), params));
        }
        gen.initUnits();
    }

    private void optimizeGenCenter() throws SemanticException {
        List<RtFunc> funcList = symbol.getAdv().getFun();
        for (RtFunc f : funcList) {
            if (f instanceof RtValidFunc) {
                RtValidFunc func = (RtValidFunc) f;
                if (func.isQuick()) {
                    RtVar var = (RtVar) func.getExp().getChilren().get(0);
                    RtTExp texp = (RtTExp) func.getExp().getChilren().get(1);
                    RtArgVarDef arg = adv.getArg(var.getVar());
                    int size = arg.getElementCount();
                    List<Integer> typeidList = arg.getElements();
                    List<RtExp> params = var.getChilren().get(0).getChilren();
                    if (size != params.size()) {
                        throw new SemanticException(params.size(), "参数数目不一致",
                                SemanticException.SemanticErrorType.EPARAM);
                    }
                    int[] param = new int[size];
                    for (int i = 0; i < size; i++) {
                        RtSetDef set = adv.getSet(typeidList.get(i));
                        SetType paramType = set.getType();
                        RtTExp paramTExp = (RtTExp) params.get(i);
                        if (paramType == SetType.NUMBER) {
                            if (!(paramTExp.getToken() instanceof RtTNumber)) {
                                throw new SemanticException(paramTExp.getToken(), "参数类型不一致",
                                        SemanticException.SemanticErrorType.EPARAM);
                            }
                        } else {
                            if (!(paramTExp.getToken() instanceof RtTString)) {
                                throw new SemanticException(paramTExp.getToken(), "参数类型不一致",
                                        SemanticException.SemanticErrorType.EPARAM);
                            }
                        }
                        int idx = set.getIndex(paramTExp.getToken().getIntValue());
                        if (idx == -1) {
                            throw new SemanticException(idx, "参数无效",
                                    SemanticException.SemanticErrorType.EPARAM);
                        }
                        param[i] = idx;
                    }
                    RtSetDef set = adv.getSet(arg.getType());
                    int retIdx = set.getIndex(texp.getToken().getIntValue());
                    gen.fixed(arg.getId(), param, retIdx);
                }
            }
        }
    }

    public IRtQueryAnswer run() throws SemanticException, CloneNotSupportedException {
        BigInteger cc = BigInteger.ZERO;
        for (; !gen.isEnd(); gen.next()) {
            if (env.check()) {
                if (debug) {
                    savedEnv.add(env.clone());
                    PrintStream out = PrologExecutor.getInstance().getOut();
                    out.println(">> 输出结果");
                    out.println("");
                    out.println("============= 输出 #" + savedEnv.size() + " ==============");
                    env.print();
                    out.println();
                } else {
                    env.print();
                }
                if (!settings.multiAnswer) {
                    break;
                }
            }
            cc = cc.add(BigInteger.ONE);
        }
        if (debug) {
            PrintStream out = PrologExecutor.getInstance().getOut();
            out.println(">> 运行循环次数: " + cc);
        }
        return this;
    }

    @Override
    public
    @NotNull
    Object queryValue(int id, @NotNull String var, Object[] params) throws SemanticException {
        if (savedEnv.isEmpty()) {
            throw new SemanticException("搜索失败", "没有搜寻到结果", SemanticException.SemanticErrorType.ENOANS);
        }
        if (id < 0 || id >= savedEnv.size()) {
            throw new SemanticException(id, "参数无效", SemanticException.SemanticErrorType.EPARAM);
        }
        RtEnv env = savedEnv.get(id);
        ValType type = symbol.getStrFactory().getVarType(var);
        if (type == ValType.NONE) {
            throw new SemanticException(var, "变量名无效", SemanticException.SemanticErrorType.EPARAM);
        }
        int varid = symbol.query(var, type);
        if (type == ValType.SINGLE) {
            return env.export(env.queryVal(type, varid, null));
        } else if (type == ValType.SEQUENCE) {
            if (params == null || params.length != 1 || !(params[0] instanceof Integer)) {
                throw new SemanticException(var, "索引值错误", SemanticException.SemanticErrorType.EPARAM);
            }
            RtSeqVarDef seq = adv.getSeq(varid);
            RtSetDef set = adv.getSet(seq.getType());
            int index = (int) params[0];
            if (index < 0 || index >= set.getElementCount()) {
                throw new SemanticException(index, "索引值无效", SemanticException.SemanticErrorType.EPARAM);
            }
            return env.export(env.queryVal(type, varid, new int[]{index}));
        } else if (type == ValType.ARGUMENT) {
            if (params == null) {
                throw new SemanticException(var, "参数错误", SemanticException.SemanticErrorType.EPARAM);
            }
            RtArgVarDef arg = adv.getArg(varid);
            int size = arg.getElementCount();
            if (params.length != size) {
                throw new SemanticException(params.length, "参数数目不一致",
                        SemanticException.SemanticErrorType.EPARAM);
            }
            List<Integer> typeidList = arg.getElements();
            int[] param = new int[size];
            for (int i = 0; i < size; i++) {
                RtSetDef set = adv.getSet(typeidList.get(i));
                SetType paramType = set.getType();
                if (params[i] == null) {
                    throw new SemanticException(i, "参数为空",
                            SemanticException.SemanticErrorType.EPARAM);
                }
                if (paramType == SetType.NUMBER) {
                    if (!(params[i] instanceof Integer)) {
                        throw new SemanticException(params[i], "参数类型不一致",
                                SemanticException.SemanticErrorType.EPARAM);
                    }
                    int idx = set.getIndex((Integer) params[i]);
                    if (idx == -1) {
                        throw new SemanticException(idx, "参数无效",
                                SemanticException.SemanticErrorType.EPARAM);
                    }
                    param[i] = idx;
                } else {
                    if (!(params[i] instanceof String)) {
                        throw new SemanticException(params[i], "参数类型不一致",
                                SemanticException.SemanticErrorType.EPARAM);
                    }
                    String string = (String) params[i];
                    int idx = symbol.query(string, symbol.getStrFactory().getVarType(string));
                    param[i] = idx;
                }
            }
            return env.export(env.queryVal(type, varid, param));
        }
        throw new NotImplementedException();
    }
}
