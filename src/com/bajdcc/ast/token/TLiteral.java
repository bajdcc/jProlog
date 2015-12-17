package com.bajdcc.ast.token;

import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 字面量
 */
public class TLiteral implements IToken, IAstComponent {

    private String literal;

    public TLiteral(@NotNull String literal) {
        this.literal = literal.substring(1, literal.length() - 1);
    }

    @Override
    public String toString() {
        return String.format("\"%s\"", literal);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void visit(IAstVisitor visitor) {
        visitor.visitBegin(this);
        visitor.visitEnd(this);
    }
}
