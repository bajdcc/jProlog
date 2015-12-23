package com.bajdcc.rt;

import com.bajdcc.ast.stmt.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 旧结构
 */
public class RtBlockOriginStruct {

    private final List<CollectionStmt> set;
    private final List<SingleVariableStmt> sin;
    private final List<ArgumentVariableStmt> arg;
    private final List<SequenceVariableStmt> seq;
    private final List<ConditionStmt> cond;

    public RtBlockOriginStruct() {
        set = new ArrayList<>();
        sin = new ArrayList<>();
        arg = new ArrayList<>();
        seq = new ArrayList<>();
        cond = new ArrayList<>();
    }

    public List<CollectionStmt> getSet() {
        return set;
    }

    public List<SingleVariableStmt> getSin() {
        return sin;
    }

    public List<ArgumentVariableStmt> getArg() {
        return arg;
    }

    public List<SequenceVariableStmt> getSeq() {
        return seq;
    }

    public List<ConditionStmt> getCond() {
        return cond;
    }
}
