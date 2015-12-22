package com.bajdcc.rt.adv.exp;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式
 */
public abstract class RtExp {

    private List<RtExp> chilren = new ArrayList<>();

    public RtExp add(RtExp exp) {
        chilren.add(exp);
        return this;
    }

    @Override
    public String toString() {
        return chilren.toString();
    }
}
