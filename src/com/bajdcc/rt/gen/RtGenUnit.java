package com.bajdcc.rt.gen;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.gen.array.IRtArray;

/**
 * 序列产生单元
 */
public abstract class RtGenUnit implements Cloneable {

    private final int id;
    private final SetType type;
    protected IRtArray array;

    public RtGenUnit(SetType type, int id, IRtArray array) {
        this.type = type;
        this.id = id;
        this.array = array;
    }

    public IRtArray getArray() {
        return array;
    }

    public int getId() {
        return id;
    }

    public SetType getType() {
        return type;
    }

    @Override
    public RtGenUnit clone() throws CloneNotSupportedException {
        RtGenUnit o = (RtGenUnit) super.clone();
        o.array = array.clone();
        return o;
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
