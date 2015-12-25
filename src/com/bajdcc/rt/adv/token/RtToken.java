package com.bajdcc.rt.adv.token;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.symbol.RtStringFactory;

/**
 * 终结符
 */
public abstract class RtToken {

    public abstract int getIntValue();

    public abstract SetType getType();

    public abstract String tryGetString(RtStringFactory sf) throws SemanticException;

    public abstract int tryGetNumber() throws SemanticException;
}
