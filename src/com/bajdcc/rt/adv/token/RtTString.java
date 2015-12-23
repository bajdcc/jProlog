package com.bajdcc.rt.adv.token;

import com.bajdcc.rt.adv.SetType;

/**
 * 字串
 */
public class RtTString extends RtToken {

    private final int id;

    public RtTString(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RtTString{" +
                "id=" + id +
                '}';
    }

    @Override
    public int getIntValue() {
        return id;
    }

    @Override
    public SetType getType() {
        return SetType.LITERAL;
    }
}
