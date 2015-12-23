package com.bajdcc.rt.adv.exp;

import com.bajdcc.rt.adv.SetType;

/**
 * 传递值结构，包含字串ID及数字
 */
public class RtVal {

    public static final RtVal NULL = new RtVal(SetType.NONE, -1);

    private final SetType type;
    private final int val;

    public RtVal(SetType type, int val) {
        this.type = type;
        this.val = val;
    }

    public SetType getType() {
        return type;
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "RtVal{" +
                "type=" + type +
                ", val=" + val +
                '}';
    }
}
