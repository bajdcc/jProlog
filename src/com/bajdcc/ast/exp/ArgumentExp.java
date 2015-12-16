package com.bajdcc.ast.exp;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 参数表达式
 */
public class ArgumentExp extends Exp {

    private List<IExp> arguments = new ArrayList<>();

    @Override
    public void addChild(@NotNull IExp exp) {
        this.arguments.add(exp);
    }

    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ");
        for (IExp argument : arguments) {
            sj.add(argument.toString());
        }
        return sj.toString();
    }
}
