package com.bajdcc.rt.adv.exp;

import com.bajdcc.ast.exp.OpType;
import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.error.SemanticException;

/**
 * 单目
 */
public class RtSop extends RtExp {

    private final OpType type;

    public RtSop(OpType type) {
        this.type = type;
    }

    @Override
    public RtVal eval(RtEnv env) throws SemanticException {
        RtVal lval = getChilren().get(0).eval(env);
        if (lval.getType() == SetType.NUMBER) {
            switch (type) {
                case NOT:
                    return new RtVal(SetType.NUMBER, (lval.getVal() == 0) ? 1 : 0);
            }
        }
        throw new SemanticException(type.getName(), "运算非法", SemanticException.SemanticErrorType.ENIMPL);
    }

    @Override
    public String toString() {
        return "RtSop{" +
                "type=" + type +
                "} " + super.toString();
    }
}
