package com.bajdcc.rt.adv.token;

/**
 * 字串
 */
public class RtTString extends RtToken {

    private int id;

    public RtTString(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RtTString{" +
                "id=" + id +
                '}';
    }
}
