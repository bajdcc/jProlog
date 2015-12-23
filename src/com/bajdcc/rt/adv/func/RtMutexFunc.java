package com.bajdcc.rt.adv.func;

import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.adv.exp.RtExp;
import com.bajdcc.rt.adv.exp.RtVal;
import com.bajdcc.rt.error.SemanticException;

import java.util.HashSet;
import java.util.Set;

/**
 * 互斥
 */
public class RtMutexFunc extends RtFunc {

    public boolean check(RtEnv env) throws SemanticException {
        RtExp args = getExp().getChilren().get(0);
        int count = args.getChilren().size();
        Set<Integer> set = new HashSet<>();
        SetType type = SetType.NONE;
        for (RtExp exp : args.getChilren()) {
            RtVal val = exp.eval(env);
            if (type == SetType.NONE) {
                type = val.getType();
            } else if (type != val.getType()) {
                throw new SemanticException(val.getVal(), "参数类型不一致",
                        SemanticException.SemanticErrorType.EPARAM);
            }
            set.add(val.getVal());
        }
        return count == set.size();
    }

    @Override
    public String toString() {
        return "RtMutexFunc{} " + super.toString();
    }
}
