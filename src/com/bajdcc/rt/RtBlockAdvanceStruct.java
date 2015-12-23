package com.bajdcc.rt;

import com.bajdcc.rt.adv.*;
import com.bajdcc.rt.symbol.ValType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新结构
 */
public class RtBlockAdvanceStruct {

    private final Map<Integer, RtSetDef> set;
    private final Map<Integer, RtSinVarDef> sin;
    private final Map<Integer, RtSeqVarDef> seq;
    private final Map<Integer, RtArgVarDef> arg;
    private final List<RtFunc> fun;

    public RtBlockAdvanceStruct() {
        set = new HashMap<>();
        sin = new HashMap<>();
        arg = new HashMap<>();
        seq = new HashMap<>();
        fun = new ArrayList<>();
    }

    public RtSetDef getSet(int id) {
        return set.get(id);
    }

    public RtSetDef getSetFromVar(ValType type, int id) {
        if (type == ValType.SINGLE) {
            RtSinVarDef sin = getSin(id);
            return getSet(sin.getType());
        } else if (type == ValType.SEQUENCE) {
            RtSeqVarDef seq = getSeq(id);
            return getSet(seq.getType());
        } else if (type == ValType.ARGUMENT) {
            RtArgVarDef arg = getArg(id);
            return getSet(arg.getType());
        }
        throw new NotImplementedException();
    }

    public void addSet(RtSetDef obj) {
        this.set.put(obj.getId(), obj);
    }

    public RtSinVarDef getSin(int id) {
        return sin.get(id);
    }

    public void addSin(RtSinVarDef obj) {
        this.sin.put(obj.getId(), obj);
    }

    public RtSeqVarDef getSeq(int id) {
        return seq.get(id);
    }

    public void addSeq(RtSeqVarDef obj) {
        this.seq.put(obj.getId(), obj);
    }

    public RtArgVarDef getArg(int id) {
        return arg.get(id);
    }

    public void addArg(RtArgVarDef obj) {
        this.arg.put(obj.getId(), obj);
    }

    public RtFunc getFunc(int id) {
        return fun.get(id);
    }

    public void addFunc(RtFunc obj) {
        this.fun.add(obj);
    }

    public Map<Integer, RtSetDef> getSet() {
        return set;
    }

    public Map<Integer, RtSinVarDef> getSin() {
        return sin;
    }

    public Map<Integer, RtSeqVarDef> getSeq() {
        return seq;
    }

    public Map<Integer, RtArgVarDef> getArg() {
        return arg;
    }

    public List<RtFunc> getFun() {
        return fun;
    }
}
