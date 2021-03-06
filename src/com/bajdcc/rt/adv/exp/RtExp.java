package com.bajdcc.rt.adv.exp;

import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.token.RtToken;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.symbol.RtSymbol;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式
 */
public abstract class RtExp {

    private final List<RtExp> chilren = new ArrayList<>();

    public void add(RtExp exp) {
        chilren.add(exp);
    }

    public void check(RtSymbol symbol, Object[] params) throws SemanticException {

    }

    public abstract RtVal eval(RtEnv env) throws SemanticException;

    public List<RtExp> getChilren() {
        return chilren;
    }

    public RtTExp tryGetToken() throws SemanticException {
        throw new SemanticException("当前类型不是终结符", "所求类型无效",
                SemanticException.SemanticErrorType.NETYPE);
    }

    @Override
    public String toString() {
        return chilren.toString();
    }
}
