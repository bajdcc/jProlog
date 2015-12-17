package com.bajdcc.ast.token;

import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 变量名
 */
public class TId implements IToken, IAstComponent {

    private String id;

    public TId(@NotNull String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public TokenType getType() {
        return TokenType.ID;
    }

    @Override
    public Object getValue() {
        return id;
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        visitor.visitBegin(this);
        visitor.visitEnd(this);
    }
}

