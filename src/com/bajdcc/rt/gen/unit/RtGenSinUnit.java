package com.bajdcc.rt.gen.unit;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.gen.RtGenUnit;
import com.bajdcc.rt.gen.array.RtRepArray;

/**
 * 单变量空间
 */
public class RtGenSinUnit extends RtGenUnit {
    public RtGenSinUnit(SetType type, int id, int count) {
        super(type, id, new RtRepArray(count, 1));
    }
}
