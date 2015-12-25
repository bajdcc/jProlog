package com.bajdcc.rt.adv.token;

import com.bajdcc.rt.adv.SetType;
import com.bajdcc.rt.error.SemanticException;
import com.bajdcc.rt.symbol.RtStringFactory;
import com.bajdcc.rt.symbol.ValType;

/**
 * 字串
 */
public class RtTString extends RtToken {

    private final int id;

    public RtTString(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RtTString{" +
                "id=" + id +
                '}';
    }

    @Override
    public int getIntValue() {
        return id;
    }

    @Override
    public SetType getType() {
        return SetType.LITERAL;
    }

    @Override
    public String tryGetString(RtStringFactory sf) throws SemanticException {
        return sf.export(id);
    }

    @Override
    public int tryGetNumber() throws SemanticException {
        throw new SemanticException("当前类型是字串", "所求类型无效",
                SemanticException.SemanticErrorType.NETYPE);
    }
}
