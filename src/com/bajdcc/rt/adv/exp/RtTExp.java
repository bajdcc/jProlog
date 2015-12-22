package com.bajdcc.rt.adv.exp;

import com.bajdcc.rt.adv.token.RtToken;

/**
 * 终结符
 */
public class RtTExp extends RtExp {

    private final RtToken token;

    public RtTExp(RtToken token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RtTExp{" +
                "token=" + token +
                "} " + super.toString();
    }
}
