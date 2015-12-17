package com.bajdcc.ast.token;

import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 数字
 */
public class TNumber implements IToken, IAstComponent {

    public static final TNumber INVALID = new TNumber("-1");

    private int number;

    public TNumber(@NotNull String number) {
        this.number = Integer.parseInt(number);
    }

    public static TNumber getINVALID() {
        return INVALID;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean isValid() {
        return number != -1;
    }

    @Override
    public TokenType getType() {
        return TokenType.NUMBER;
    }

    @Override
    public Object getValue() {
        return number;
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        visitor.visitBegin(this);
        visitor.visitEnd(this);
    }
}
