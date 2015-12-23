package com.bajdcc.rt.gen;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.adv.exp.RtVal;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.gen.array.IRtArray;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 序列产生中心
 */
public class RtGenCenter implements Cloneable {

    private boolean end = true;
    private boolean empty = true;
    private Map<Integer, RtGenUnit> unitMap = new HashMap<>();
    private List<RtGenUnit> unitList = new ArrayList<>();

    public void clear() {
        end = empty;
        unitMap.clear();
        unitList.clear();
    }

    public void reset() {
        end = empty;
        for (RtGenUnit unit : unitList) {
            unit.getArray().reset();
        }
    }

    public boolean available() {
        return !unitList.isEmpty();
    }

    public void addUnit(@NotNull RtGenUnit unit) {
        unitMap.put(unit.getId(), unit);
    }

    public void initUnits() {
        unitList.addAll(unitMap.values());
        if (!unitList.isEmpty()) {
            empty = false;
        }
        end = empty;
    }

    public void next() {
        if (!end) {
            final int size = unitList.size();
            for (int i = 0; i < size; i++) {
                IRtArray arr = unitList.get(i).getArray();
                if (arr.isEnd()) {
                    if (i == size - 1) {
                        end = true;
                        break;
                    }
                    arr.reset();
                } else {
                    arr.next();
                    break;
                }
            }
        }
    }

    public RtVal query(int var, int[] params) throws SemanticException {
        if (unitMap.containsKey(var)) {
            RtGenUnit unit = unitMap.get(var);
            int val = unit.getArray().get(params);
            SetType type = unit.getType();
            return new RtVal(type, val);
        }
        return RtVal.NULL;
    }

    public void fixed(int var, int[] params, int ret) {
        unitMap.get(var).getArray().fixed(params, ret);
    }

    public boolean isEnd() {
        return end;
    }

    @Override
    public RtGenCenter clone() throws CloneNotSupportedException {
        RtGenCenter o = (RtGenCenter) super.clone();
        o.unitMap = new HashMap<>();
        o.unitList = new ArrayList<>();
        for (RtGenUnit unit : unitList) {
            o.addUnit(unit.clone());
        }
        o.initUnits();
        return o;
    }

    @Override
    public String toString() {
        return unitList.toString();
    }
}
