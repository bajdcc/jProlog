package com.bajdcc.rt;

import com.bajdcc.rt.adv.RtFunc;
import com.bajdcc.rt.adv.exp.RtExp;
import com.sun.istack.internal.NotNull;

import java.util.Stack;

/**
 * 树结点重构
 */
public class RtTreeExpBuilder {

    private RtFunc func;
    private final Stack<RtExp> path = new Stack<>();

    public void push(@NotNull RtExp exp) {
        if (!path.empty()) {
            path.peek().add(exp);
        }
        path.push(exp);
    }

    public void pop() {
        if (path.size() == 1 && this.func != null) {
            this.func.set(path.peek());
        }
        path.pop();
    }

    public RtExp current() {
        return path.peek();
    }

    public boolean empty() {
        return path.empty();
    }

    public boolean isEmptyFunc() {
        return this.func == null;
    }

    public void clearFunc() {
        if (this.func == null || !this.path.empty()) {
            throw new RuntimeException();
        }
        this.func = null;
    }

    public RtFunc getFunc() {
        return this.func;
    }

    public void setFunc(@NotNull RtFunc func) {
        if (this.func != null) {
            throw new RuntimeException();
        }
        this.func = func;
    }
}
