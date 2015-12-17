package com.bajdcc.visit;

/**
 * 参数
 */
public class AstVisitorArgs {

    private boolean visitChildren = true;
    private boolean visitEnd = true;

    public boolean canVisitChildren() {
        return visitChildren;
    }

    public void setVisitChildren(boolean visitChildren) {
        this.visitChildren = visitChildren;
    }

    public boolean canVisitEnd() {
        return visitEnd;
    }

    public void setVisitEnd(boolean visitEnd) {
        this.visitEnd = visitEnd;
    }
}
