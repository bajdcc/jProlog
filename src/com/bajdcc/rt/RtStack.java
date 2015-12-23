package com.bajdcc.rt;

import com.bajdcc.ast.token.IToken;
import com.sun.istack.internal.NotNull;

import java.util.Stack;

/**
 * 状态栈
 */
public class RtStack {

    private final Stack<StateStruct> stack;

    public RtStack() {
        stack = new Stack<>();
    }

    public void push(@NotNull RtBlock.StateType type, @NotNull IToken token) {
        stack.push(new StateStruct(type, token));
    }

    public void push(@NotNull RtBlock.StateType type) {
        stack.push(new StateStruct(type, null));
    }

    public void pop() {
        stack.pop();
    }

    public void pop(@NotNull RtBlock.StateType type) {
        if (top().getType() == type) {
            stack.pop();
        }
    }

    public
    @NotNull
    StateStruct top() {
        if (stack.empty()) {
            return new StateStruct(RtBlock.StateType.NONE, null);
        }
        return stack.peek();
    }

    public class StateStruct {
        private final RtBlock.StateType type;
        private final IToken token;

        public StateStruct(RtBlock.StateType type, IToken token) {
            this.type = type;
            this.token = token;
        }

        public RtBlock.StateType getType() {
            return type;
        }

        public IToken getToken() {
            return token;
        }
    }
}
