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

    public void disableVisitChildren() {
        this.visitChildren = false;
    }

    public boolean canVisitEnd() {
        return visitEnd;
    }

    public void disableVisitEnd() {
        this.visitEnd = false;
    }
}
