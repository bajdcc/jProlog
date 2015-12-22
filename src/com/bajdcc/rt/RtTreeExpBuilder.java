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
    private Stack<RtExp> path = new Stack<>();

    public void push(@NotNull RtExp exp) {
        if (!path.empty()) {
            path.peek().add(exp);
        }
        path.push(exp);
    }

    public void pop() {
        if (path.size() == 1) {
            assert this.func != null;
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

    public boolean available() {
        return this.func != null;
    }

    public void clearFunc() {
        assert this.func != null;
        assert this.path.empty();
        this.func = null;
    }

    public RtFunc getFunc() {
        return this.func;
    }

    public void setFunc(@NotNull RtFunc func) {
        assert this.func == null;
        this.func = func;
    }
}
