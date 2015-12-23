package com.bajdcc.rt.adv.exp;

import com.bajdcc.ast.exp.OpType;
import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.error.SemanticException;

/**
 * 双目
 */
public class RtBop extends RtExp {

    private final OpType type;

    public RtBop(OpType type) {
        this.type = type;
    }

    @Override
    public RtVal eval(RtEnv env) throws SemanticException {
        RtVal lval = getChilren().get(0).eval(env);
        RtVal rval = getChilren().get(1).eval(env);
        if (lval.getType() != rval.getType()) {
            throw new SemanticException(lval.getType() + " != " + rval.getType(), "双目运算类型不一致",
                    SemanticException.SemanticErrorType.NETYPE);
        }
        if (lval.getType() == SetType.NUMBER) {
            switch (type) {
                case EQ:
                    return new RtVal(SetType.NUMBER, (lval.getVal() == rval.getVal()) ? 1 : 0);
                case NEQ:
                    return new RtVal(SetType.NUMBER, (lval.getVal() != rval.getVal()) ? 1 : 0);
                case LT:
                    return new RtVal(SetType.NUMBER, (lval.getVal() < rval.getVal()) ? 1 : 0);
                case LTE:
                    return new RtVal(SetType.NUMBER, (lval.getVal() <= rval.getVal()) ? 1 : 0);
                case GT:
                    return new RtVal(SetType.NUMBER, (lval.getVal() > rval.getVal()) ? 1 : 0);
                case GTE:
                    return new RtVal(SetType.NUMBER, (lval.getVal() >= rval.getVal()) ? 1 : 0);
                case PLUS:
                    return new RtVal(SetType.NUMBER, (lval.getVal() + rval.getVal()));
                case MINUS:
                    return new RtVal(SetType.NUMBER, (lval.getVal() - rval.getVal()));
                case MUL:
                    return new RtVal(SetType.NUMBER, (lval.getVal() * rval.getVal()));
                case DIV:
                    return new RtVal(SetType.NUMBER, (lval.getVal() / rval.getVal()));
                case MOD:
                    return new RtVal(SetType.NUMBER, (lval.getVal() % rval.getVal()));
                case AND:
                    return new RtVal(SetType.NUMBER, (lval.getVal() & rval.getVal()));
                case OR:
                    return new RtVal(SetType.NUMBER, (lval.getVal() | rval.getVal()));
                case XOR:
                    return new RtVal(SetType.NUMBER, (lval.getVal() ^ rval.getVal()));
                case IMPLY:
                    return new RtVal(SetType.NUMBER, ((lval.getVal() == 0 ? 1 : 0) | rval.getVal()));
            }
        } else {
            switch (type) {
                case EQ:
                    return new RtVal(SetType.NUMBER, (lval.getVal() == rval.getVal()) ? 1 : 0);
                case NEQ:
                    return new RtVal(SetType.NUMBER, (lval.getVal() != rval.getVal()) ? 1 : 0);
            }
        }
        throw new SemanticException(type.getName(), "运算非法", SemanticException.SemanticErrorType.ENIMPL);
    }

    @Override
    public String toString() {
        return "RtBop{" +
                "type=" + type +
                "} " + super.toString();
    }
}
