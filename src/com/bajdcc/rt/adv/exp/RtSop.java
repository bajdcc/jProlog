package com.bajdcc.rt.adv.exp;

import com.bajdcc.ast.exp.OpType;

/**
 * 单目
 */
public class RtSop extends RtExp {

    private OpType type;

    public RtSop(OpType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RtSop{" +
                "type=" + type +
                "} " + super.toString();
    }
}
