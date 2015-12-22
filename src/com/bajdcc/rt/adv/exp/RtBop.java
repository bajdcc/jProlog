package com.bajdcc.rt.adv.exp;

import com.bajdcc.ast.exp.OpType;

/**
 * 双目
 */
public class RtBop extends RtExp {

    private OpType type;

    public RtBop(OpType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RtBop{" +
                "type=" + type +
                "} " + super.toString();
    }
}
