package com.bajdcc.rt.adv.func;

import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.adv.exp.RtExp;
import com.bajdcc.rt.error.SemanticException;

import java.io.PrintStream;

/**
 * 输出
 */
public class RtPrintFunc extends RtFunc {

    public void print(RtEnv env) throws SemanticException {
        PrintStream ps = env.getOutput();
        for (RtExp exp : getExp().getChilren().get(0).getChilren()) {
            ps.print(env.export(exp.eval(env)));
        }
        ps.println();
    }

    @Override
    public String toString() {
        return "RtPrintFunc{} " + super.toString();
    }
}
