package com.bajdcc.rt.gen.unit;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.gen.RtGenUnit;
import com.bajdcc.rt.gen.array.RtNArray;

/**
 * 参变量空间
 */
public class RtGenArgUnit extends RtGenUnit {
    public RtGenArgUnit(SetType type, int id, int ret, int[] params) {
        super(type, id, new RtNArray(ret, params));
    }
}
