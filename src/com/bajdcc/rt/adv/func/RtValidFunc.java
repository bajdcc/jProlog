package com.bajdcc.rt.adv.func;

import com.bajdcc.ast.exp.QuantifierExp;
import com.bajdcc.rt.RtEnv;
import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.adv.RtSetDef;
import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.adv.exp.RtExp;
import com.bajdcc.rt.adv.exp.RtVal;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.gen.RtGenCenter;
import com.bajdcc.rt.gen.unit.RtGenSinUnit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 通用验证
 */
public class RtValidFunc extends RtFunc {

    private final List<QuanStruct> quanList = new ArrayList<>();
    private final Set<Integer> setTmp = new HashSet<>();
    private boolean quanCheck = false;
    private boolean quanEmpty = true;
    private boolean quick = false;

    public void add(QuantifierExp.QuantifierType type, int id, int tmp) throws SemanticException {
        quanList.add(new QuanStruct(type, id, tmp));
        if (setTmp.contains(tmp)) {
            return;
        }
        setTmp.add(tmp);
    }

    public boolean isQuick() {
        return quick;
    }

    public void setQuick(boolean quick) {
        this.quick = quick;
    }

    @Override
    public String toString() {
        return "RtValidFunc{" +
                "quanList=" + quanList +
                "} " + super.toString();
    }

    public boolean check(RtEnv env) throws SemanticException {
        if (!quanCheck) {
            quanEmpty = quanList.isEmpty();
            quanCheck = true;
        }
        final RtExp exp = getExp();
        if (quanEmpty) {
            RtVal val = exp.eval(env);
            if (val.getType() != SetType.NUMBER) {
                throw new SemanticException(val.getVal(), "不是布尔表达式",
                        SemanticException.SemanticErrorType.EPARAM);
            }
            return val.getVal() != 0;
        } else {
            RtGenCenter all = env.getTmpAll();
            RtGenCenter exist = env.getTmpExist();
            for (QuanStruct quan : quanList) {
                RtSetDef set = env.getAdv().getSet(quan.getId());
                if (quan.getType() == QuantifierExp.QuantifierType.UNIVERSAL) {
                    all.addUnit(new RtGenSinUnit(set.getType(), quan.getTmp(), set.getElementCount()));
                    all.initUnits();
                } else {
                    exist.addUnit(new RtGenSinUnit(set.getType(), quan.getTmp(), set.getElementCount()));
                    exist.initUnits();
                }
            }
            boolean successAll = false;
            for (; ; ) {
                boolean successExist = false;
                for (; ; ) {
                    RtVal val = exp.eval(env);
                    if (val.getType() != SetType.NUMBER) {
                        throw new SemanticException(val.getVal(), "不是布尔表达式",
                                SemanticException.SemanticErrorType.EPARAM);
                    }
                    if (val.getVal() != 0) {
                        successExist = true;
                        break;
                    }
                    if (exist.isEnd()) {
                        break;
                    } else {
                        exist.next();
                    }
                }
                if (!successExist) {//not exist = failed
                    break;
                }
                exist.reset();
                if (all.isEnd()) {
                    successAll = true;
                    break;
                } else {
                    all.next();
                }
            }
            all.clear();
            exist.clear();
            return successAll;
        }
    }

    private class QuanStruct {
        private final QuantifierExp.QuantifierType type;
        private final int id;
        private final int tmp;

        public QuanStruct(QuantifierExp.QuantifierType type, int id, int tmp) {
            this.type = type;
            this.id = id;
            this.tmp = tmp;
        }

        public QuantifierExp.QuantifierType getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public int getTmp() {
            return tmp;
        }

        @Override
        public String toString() {
            return "QuanStruct{" +
                    "type=" + type +
                    ", id=" + id +
                    ", tmp=" + tmp +
                    '}';
        }
    }
}
