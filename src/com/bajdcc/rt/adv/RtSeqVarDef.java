package com.bajdcc.rt.adv;

/**
 * 序变量
 */
public class RtSeqVarDef {

    private final int id;
    private final int type;

    public RtSeqVarDef(int id, int type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }
}
