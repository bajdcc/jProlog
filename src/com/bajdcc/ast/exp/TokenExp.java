package com.bajdcc.ast.exp;

import com.bajdcc.ast.token.IToken;
import com.bajdcc.visit.AstVisitorArgs;
import com.bajdcc.visit.IAstComponent;
import com.bajdcc.visit.IAstVisitor;
import com.sun.istack.internal.NotNull;

/**
 * 字符表达式
 */
public class TokenExp extends Exp implements IAstComponent {

    private IToken token;

    public TokenExp(@NotNull IToken token) {
        this.token = token;
    }

    public IToken getToken() {
        return token;
    }

    @Override
    public String toString() {
        return token.toString();
    }

    @Override
    public void visit(IAstVisitor visitor) throws Exception {
        AstVisitorArgs args = new AstVisitorArgs();
        visitor.visitBegin(this, args);
        if (args.canVisitChildren()) {
            token.visit(visitor);
        }
        if (args.canVisitEnd()) {
            visitor.visitEnd(this);
        }
    }
}
