package com.bajdcc.visit;

import com.sun.istack.internal.NotNull;

/**
 * 被访问者
 */
public interface IAstComponent {

    void visit(@NotNull IAstVisitor visitor) throws Exception;
}
