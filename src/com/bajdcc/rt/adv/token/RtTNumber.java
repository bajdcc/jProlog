package com.bajdcc.rt.adv.token;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.symbol.RtStringFactory;

/**
 * 数字
 */
public class RtTNumber extends RtToken {

    private final int number;

    public RtTNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "RtTNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public int getIntValue() {
        return number;
    }

    @Override
    public SetType getType() {
        return SetType.NUMBER;
    }

    @Override
    public String tryGetString(RtStringFactory sf) throws SemanticException {
        throw new SemanticException("当前类型是数字", "所求类型无效",
                SemanticException.SemanticErrorType.NETYPE);
    }

    @Override
    public int tryGetNumber() throws SemanticException {
        return number;
    }
}
