package com.bajdcc.rt.adv.token;

/**
 * 数字
 */
public class RtTNumber extends RtToken {

    private int number;

    public RtTNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RtTNumber{" +
                "number=" + number +
                '}';
    }
}
