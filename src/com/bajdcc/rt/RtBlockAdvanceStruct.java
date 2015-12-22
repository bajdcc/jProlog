package com.bajdcc.rt;

import com.bajdcc.rt.adv.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新结构
 */
public class RtBlockAdvanceStruct {

    private Map<Integer, RtSetDef> set;
    private Map<Integer, RtSinVarDef> sin;
    private Map<Integer, RtSeqVarDef> seq;
    private Map<Integer, RtArgVarDef> arg;
    private List<RtFunc> fun;

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
}
