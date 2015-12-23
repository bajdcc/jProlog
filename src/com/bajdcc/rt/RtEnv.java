package com.bajdcc.rt;

import com.bajdcc.prolog.PrologExecutor;
import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.adv.RtSetDef;
import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.adv.exp.RtVal;
import com.bajdcc.rt.adv.func.RtMutexFunc;
import com.bajdcc.rt.adv.func.RtPrintFunc;
import com.bajdcc.rt.adv.func.RtSettingFunc;
import com.bajdcc.rt.adv.func.RtValidFunc;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.gen.RtGenCenter;
import com.bajdcc.rt.symbol.RtStringFactory;
import com.bajdcc.rt.symbol.RtSymbol;
import com.bajdcc.rt.symbol.ValType;
import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 运行时环境
 */
public class RtEnv implements Cloneable {

    private final RtStringFactory sf;
    private RtGenCenter gen;
    private final RtGenCenter tmpAll;
    private final RtGenCenter tmpExist;
    private final RtBlockAdvanceStruct adv;
    private final List<RtValidFunc> validFunc;
    private final List<RtPrintFunc> printFunc;
    private final List<RtMutexFunc> mutexFunc;
    private final RtSettings settings;

    public RtEnv(@NotNull RtSymbol symbol) {
        this.sf = symbol.getStrFactory();
        this.adv = symbol.getAdv();
        this.gen = new RtGenCenter();
        this.tmpAll = new RtGenCenter();
        this.tmpExist = new RtGenCenter();
        this.validFunc = new ArrayList<>();
        this.printFunc = new ArrayList<>();
        this.mutexFunc = new ArrayList<>();
        this.settings = new RtSettings();
    }

    public void initFunc() throws SemanticException {
        List<RtFunc> funcList = adv.getFun();
        for (RtFunc f : funcList) {
            if (f instanceof RtValidFunc) {
                if (!((RtValidFunc) f).isQuick()) {
                    validFunc.add((RtValidFunc) f);
                }
            } else if (f instanceof RtPrintFunc) {
                printFunc.add((RtPrintFunc) f);
            } else if (f instanceof RtMutexFunc) {
                mutexFunc.add((RtMutexFunc) f);
            } else if (f instanceof RtSettingFunc) {
                ((RtSettingFunc) f).set(this);
            }
        }
    }

    public RtBlockAdvanceStruct getAdv() {
        return adv;
    }

    public RtGenCenter getGen() {
        return gen;
    }

    public RtGenCenter getTmpAll() {
        return tmpAll;
    }

    public RtGenCenter getTmpExist() {
        return tmpExist;
    }

    public RtSettings getSettings() {
        return settings;
    }

    public boolean check() throws SemanticException {
        for (RtMutexFunc func : mutexFunc) {
            if (!func.check(this)) {
                return false;
            }
        }
        for (RtValidFunc func : validFunc) {
            if (!func.check(this)) {
                return false;
            }
        }
        return true;
    }

    public void print() throws SemanticException {
        for (RtPrintFunc func : printFunc) {
            func.print(this);
        }
    }

    public PrintStream getOutput() {
        return PrologExecutor.getInstance().getOut();
    }

    public RtVal queryVal(ValType type, int var, int[] params) throws SemanticException {
        final int[] ONE = new int[]{1};
        RtVal val;
        switch (type) {
            case SINGLE:
                return transfer(type, gen.query(var, ONE), var);
            case SEQUENCE:
            case ARGUMENT:
                return transfer(type, gen.query(var, params), var);
            case TMPID:
                if (tmpAll.available()) {
                    val = tmpAll.query(var, ONE);
                    if (val.getType() != SetType.NONE) {
                        return val;
                    }
                }
                if (tmpExist.available()) {
                    val = tmpExist.query(var, ONE);
                    if (val.getType() != SetType.NONE) {
                        return val;
                    }
                }
                break;
        }
        throw new SemanticException(var, "查询失败", SemanticException.SemanticErrorType.EPARAM);
    }

    private RtVal transfer(ValType type, RtVal val, int id) {
        return getOriginIndex(val, adv.getSetFromVar(type, id));
    }

    private RtVal getOriginIndex(RtVal val, RtSetDef set) {
        return new RtVal(val.getType(), set.getElementById(val.getVal()));
    }

    public Object export(@NotNull RtVal val) {
        switch (val.getType()) {
            case NONE:
                break;
            case LITERAL:
                return sf.export(val.getVal());
            case NUMBER:
                return val.getVal();
        }
        throw new NotImplementedException();
    }

    @Override
    public RtEnv clone() throws CloneNotSupportedException {
        RtEnv o = (RtEnv) super.clone();
        o.gen = gen.clone();
        return o;
    }
}
