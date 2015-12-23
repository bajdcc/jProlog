package com.bajdcc.rt.gen.array;

import com.sun.istack.internal.NotNull;

/**
 * 数组
 */
public interface IRtArray extends Cloneable {
    void reset();

    boolean isEnd();

    void next();

    int get(@NotNull int[] vals);

    @NotNull
    IRtArray clone() throws CloneNotSupportedException;

    void fixed(int[] params, int ret);
}
