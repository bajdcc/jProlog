package com.bajdcc.rt.adv.token;

import com.bajdcc.rt.adv.SetType;

/**
 * 终结符
 */
public abstract class RtToken {

    public abstract int getIntValue();

    public abstract SetType getType();
}
