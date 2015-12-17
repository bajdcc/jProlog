package com.bajdcc.ast.token;

import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 范围
 */
public class TRange implements IToken, IAstComponent {

    private int lower;
    private int upper;

    public TRange(@NotNull String lower, @NotNull String upper) {
        this.lower = Integer.parseInt(lower);
        this.upper = Integer.parseInt(upper);
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    @Override
    public String toString() {
        return String.format("%d:%d", lower, upper);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public TokenType getType() {
        return TokenType.RANGE;
    }

    @Override
    public Object getValue() {
        return lower + "-" + upper;
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        visitor.visitBegin(this);
        visitor.visitEnd(this);
    }
}
