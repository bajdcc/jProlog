package com.bajdcc.rt.gen.array;

import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * 一维重复全排列
 */
public class RtRepArray implements IRtArray {

    private static final int START = 1;

    /**
     * 取值空间
     */
    private final int ret;
    /**
     * 参数空间
     */
    private final int count;

    private boolean end;
    private int[] narr;

    public RtRepArray(int ret, int count) {
        this.ret = ret;
        this.count = count;
        this.narr = new int[count];
        reset();
    }

    @Override
    public void reset() {
        this.end = false;
        Arrays.fill(narr, START);
    }

    @Override
    public boolean isEnd() {
        return end;
    }

    @Override
    public void next() {
        for (int i = 0; i < count; i++) {
            int k = narr[i];
            k++;
            if (k >= ret) {
                if (i == count - 1) {
                    narr[i] = k;
                    end = true;
                    break;
                }
                narr[i] = START;
            } else {
                narr[i] = k;
                break;
            }
        }
    }

    @Override
    public int get(@NotNull int[] vals) {
        return narr[vals[0] - 1];
    }

    @Override
    public IRtArray clone() throws CloneNotSupportedException {
        RtRepArray o = (RtRepArray) super.clone();
        o.narr = narr.clone();
        return o;
    }

    @Override
    public void fixed(int[] params, int ret) {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        return "RtRepArray{" +
                "ret=" + ret +
                ", count=" + count +
                ", end=" + end +
                ", narr=" + Arrays.toString(narr) +
                '}';
    }
}
