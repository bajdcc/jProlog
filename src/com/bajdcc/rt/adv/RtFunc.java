package com.bajdcc.rt.adv;

import com.bajdcc.rt.adv.exp.RtExp;

/**
 * 调用
 */
public abstract class RtFunc {

    private RtExp exp;

    public void set(RtExp exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "RtFunc{" +
                "exp=" + exp +
                '}';
    }
}
