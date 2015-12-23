package com.bajdcc.rt.adv.exp;

import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.error.SemanticException;

/**
 * 参数
 */
public class RtArgs extends RtExp {

    @Override
    public RtVal eval(RtEnv env) throws SemanticException {
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return "RtArgs{} " + super.toString();
    }
}
