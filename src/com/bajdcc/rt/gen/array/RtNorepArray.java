package com.bajdcc.rt.gen.array;

import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * 一维不重复全排列
 */
public class RtNorepArray implements IRtArray {

    private static final int START = 1;

    /**
     * 取值空间，参数空间
     */
    private final int ret;

    private boolean end;
    private int[] narr;

    public RtNorepArray(int ret) {
        this.ret = ret;
        this.narr = new int[ret];
        reset();
    }

    @Override
    public void reset() {
        this.end = false;
        for (int i = 0; i < ret; i++) {
            narr[i] = i + 1;
        }
    }

    @Override
    public boolean isEnd() {
        return end;
    }

    @Override
    public void next() {
        // a[k]<a[k+1] and max(k)
        int k = -1;
        for (int i = 0; i < ret - 1; i++) {
            if (narr[i] < narr[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            end = true;
            return;
        }
        // j>k && a[j]>a[k] && min(a[j])
        int j = k + 1;
        int ak = narr[k];
        for (int i = j + 1; i < ret; i++) {
            int ai = narr[i];
            if (ai > ak && ai < narr[j]) {
                j = i;
            }
        }
        // a[j] <-> a[k]
        int tmp = narr[j];
        narr[j] = ak;
        narr[k] = tmp;
        // reverse a[k+1..end]
        for (int i = 0; i <= (ret - k - 1) / 2 - 1; i++) {
            tmp = narr[k + i + 1];
            narr[k + i + 1] = narr[ret - i - 1];
            narr[ret - i - 1] = tmp;
        }
    }

    @Override
    public int get(@NotNull int[] vals) {
        return narr[vals[0] - 1];
    }

    public int[] getArray() {
        return narr;
    }

    @Override
    public IRtArray clone() throws CloneNotSupportedException {
        RtNorepArray o = (RtNorepArray) super.clone();
        o.narr = narr.clone();
        return o;
    }

    @Override
    public void fixed(int[] params, int ret) {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        return "RtNorepArray{" +
                "ret=" + ret +
                ", end=" + end +
                ", narr=" + Arrays.toString(narr) +
                '}';
    }
}
