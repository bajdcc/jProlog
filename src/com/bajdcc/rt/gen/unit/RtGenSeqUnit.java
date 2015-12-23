package com.bajdcc.rt.gen.unit;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.gen.RtGenUnit;
import com.bajdcc.rt.gen.array.RtNorepArray;

/**
 * 序变量空间
 */
public class RtGenSeqUnit extends RtGenUnit {
    public RtGenSeqUnit(SetType type, int id, int count) {
        super(type, id, new RtNorepArray(count));
    }
}
