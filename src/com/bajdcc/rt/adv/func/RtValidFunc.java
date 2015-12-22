package com.bajdcc.rt.adv.func;

import com.bajdcc.ast.exp.QuantifierExp;
import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.error.SemanticException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 通用验证
 */
public class RtValidFunc extends RtFunc {

    private List<QuanStruct> quanList = new ArrayList<>();
    private Set<Integer> setTmp = new HashSet<>();

    public boolean add(QuantifierExp.QuantifierType type, int id, int tmp) throws SemanticException {
        quanList.add(new QuanStruct(type, id, tmp));
        if (setTmp.contains(tmp)) {
            return false;
        }
        setTmp.add(tmp);
        return true;
    }

    @Override
    public String toString() {
        return "RtValidFunc{" +
                "quanList=" + quanList +
                "} " + super.toString();
    }

    private class QuanStruct {
        private QuantifierExp.QuantifierType type;
        private int id;
        private int tmp;

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
