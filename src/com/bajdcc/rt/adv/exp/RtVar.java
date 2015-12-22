package com.bajdcc.rt.adv.exp;

/**
 * 变量
 */
public class RtVar extends RtExp {

    private final VarType type;
    private final int var;

    public RtVar(VarType type, int var) {
        this.type = type;
        this.var = var;
    }

    @Override
    public String toString() {
        return "RtVar{" +
                "type=" + type +
                ", var=" + var +
                "} " + super.toString();
    }

    public enum VarType {
        SIN,
        SEQ,
        ARG,
        FUNC
    }
}
