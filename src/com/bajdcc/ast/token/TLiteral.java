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

    public String getLiteral() {
        return literal;
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
    public TokenType getType() {
        return TokenType.LITERAL;
    }

    @Override
    public Object getValue() {
        return literal;
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        visitor.visitBegin(this);
        visitor.visitEnd(this);
    }
}
