package com.bajdcc.visit;

/**
 * 被访问者
 */
public interface IAstComponent {

    void visit(IAstVisitor visitor);
}
