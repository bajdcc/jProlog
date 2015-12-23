package com.bajdcc.rt.adv.token;

import com.bajdcc.rt.adv.SetType;

/**
 * 数字
 */
public class RtTNumber extends RtToken {

    private final int number;

    public RtTNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RtTNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public int getIntValue() {
        return number;
    }

    @Override
    public SetType getType() {
        return SetType.NUMBER;
    }
}
