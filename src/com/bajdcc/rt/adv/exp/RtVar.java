package com.bajdcc.rt.adv.exp;

import com.bajdcc.rt.RtBlockAdvanceStruct;
import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.RtArgVarDef;
import com.bajdcc.rt.adv.RtSeqVarDef;
import com.bajdcc.rt.adv.RtSetDef;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.symbol.RtSymbol;
import com.bajdcc.rt.symbol.ValType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * 变量
 */
public class RtVar extends RtExp {

    private final ValType type;
    private final int var;

    public RtVar(ValType type, int var) {
        this.type = type;
        this.var = var;
    }

    @Override
    public void check(RtSymbol symbol, Object[] params) throws SemanticException {
        if (type == ValType.SEQUENCE) {
            int index = (int) params[0];
            RtSeqVarDef seq = symbol.getAdv().getSeq(var);
            RtSetDef set = symbol.getAdv().getSet(seq.getType());
            if (index <= 0 || index > set.getElementCount()) {
                throw new SemanticException(index, "参数不在范围内",
                        SemanticException.SemanticErrorType.EPARAM);
            }
        } else if (type == ValType.ARGUMENT) {
            int count = (int) params[0];
            RtArgVarDef arg = symbol.getAdv().getArg(var);
            if (count != arg.getElementCount()) {
                throw new SemanticException(count, "参数数目不一致",
                        SemanticException.SemanticErrorType.EPARAM);
            }
        }
    }

    @Override
    public RtVal eval(RtEnv env) throws SemanticException {
        if (type == ValType.SINGLE) {
            return env.queryVal(type, var, null);
        } else if (type == ValType.SEQUENCE) {
            RtVal val = getChilren().get(0).eval(env);
            return env.queryVal(type, var, new int[]{val.getVal()});
        } else if (type == ValType.ARGUMENT) {
            List<RtExp> children = getChilren().get(0).getChilren();
            final int size = children.size();
            final RtVal[] vals = new RtVal[size];
            final RtBlockAdvanceStruct adv = env.getAdv();
            List<Integer> arg = adv.getArg(var).getElements();
            final int[] params = new int[size];
            for (int i = 0; i < size; i++) {
                vals[i] = children.get(i).eval(env);
                RtSetDef set = adv.getSet(arg.get(i));
                if (vals[i].getType() != set.getType()) {
                    throw new SemanticException(vals[i].getVal(), "参数类型不一致",
                            SemanticException.SemanticErrorType.EPARAM);
                }
                int idx = set.getIndex(vals[i].getVal());
                if (idx == -1) {
                    throw new SemanticException(vals[i].getVal(), "参数无效",
                            SemanticException.SemanticErrorType.EPARAM);
                }
                params[i] = idx;
            }
            return env.queryVal(type, var, params);
        } else if (type == ValType.TMPID) {
            return env.queryVal(type, var, null);
        }
        throw new NotImplementedException();
    }

    public ValType getType() {
        return type;
    }

    public int getVar() {
        return var;
    }

    @Override
    public String toString() {
        return "RtVar{" +
                "type=" + type +
                ", var=" + var +
                "} " + super.toString();
    }
}
