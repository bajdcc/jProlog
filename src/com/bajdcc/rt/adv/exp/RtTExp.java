package com.bajdcc.rt.adv.exp;

import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.token.RtToken;
import com.bajdcc.rt.error.SemanticException;

/**
 * 终结符
 */
public class RtTExp extends RtExp {

    private final RtToken token;

    public RtTExp(RtToken token) {
        this.token = token;
    }

    public RtToken getToken() {
        return token;
    }

    @Override
    public RtVal eval(RtEnv env) throws SemanticException {
        return new RtVal(token.getType(), token.getIntValue());
    }

    @Override
    public String toString() {
        return "RtTExp{" +
                "token=" + token +
                "} " + super.toString();
    }
}
