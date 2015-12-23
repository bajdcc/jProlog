package com.bajdcc.rt.gen.array;

import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * 多维数组
 * <p>可能性：<i>pow(val, n1*n2*...)</i></p>
 */
public class RtNArray implements IRtArray {

    private static final int START = 1;

    /**
     * 取值空间
     */
    private final int ret;
    /**
     * 参数空间
     */
    private final int[] param;
    private final int all;
    private boolean end;
    private List<Integer> narr;
    private final Set<Integer> fixed;

    public RtNArray(int ret, int[] param) {
        this.ret = ret;
        int fac = 1;
        for (int i : param) {
            fac *= i;
        }
        this.all = fac;
        System.arraycopy(param, 1, param, 0, param.length - 1);
        param[param.length - 1] = 1;
        this.param = param;
        this.narr = new ArrayList<>();
        for (int i = 0; i < all; i++) {
            narr.add(START);
        }
        this.fixed = new HashSet<>();
        reset();
    }

    @Override
    public void reset() {
        this.end = false;
        for (int i = 0; i < all; i++) {
            if (!fixed.isEmpty() && !fixed.contains(i)) {
                narr.set(i, START);
            }
        }
    }

    @Override
    public boolean isEnd() {
        return end;
    }

    @Override
    public void next() {
        int i;
        for (i = 0; i < all; i++) {
            if (!fixed.isEmpty() && fixed.contains(i)) {
                continue;
            }
            int k = narr.get(i);
            k++;
            if (k > ret) {
                narr.set(i, START);
            } else {
                narr.set(i, k);
                return;
            }
        }
        if (i == all) {
            end = true;
        }
    }

    @Override
    public int get(@NotNull int[] vals) {
        int index = 0;
        for (int i = 0; i < param.length; i++) {
            index += param[i] * (vals[i] - 1);
        }
        return narr.get(index);
    }

    @Override
    public IRtArray clone() throws CloneNotSupportedException {
        RtNArray o = (RtNArray) super.clone();
        o.narr = new ArrayList<>(narr);
        return o;
    }

    @Override
    public void fixed(int[] params, int ret) {
        int index = 0;
        for (int i = 0; i < param.length; i++) {
            index += param[i] * (params[i] - 1);
        }
        narr.set(index, ret);
        fixed.add(index);
    }

    @Override
    public String toString() {
        return "RtNArray{" +
                "ret=" + ret +
                ", param=" + Arrays.toString(param) +
                ", end=" + end +
                ", all=" + all +
                ", narr=" + narr +
                '}';
    }
}
