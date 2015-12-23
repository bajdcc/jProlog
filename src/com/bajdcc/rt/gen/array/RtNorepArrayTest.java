package com.bajdcc.rt.gen.array;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

/**
 * 不重复非排列测试
 */
public class RtNorepArrayTest extends TestCase {

    public void testArray2() {
        RtNorepArray arr = new RtNorepArray(2);
        assertArrayEquals(new int[]{1, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 1}, arr.getArray());
        arr.next();
    }

    public void testArray3() {
        RtNorepArray arr = new RtNorepArray(3);
        assertArrayEquals(new int[]{1, 2, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{1, 3, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 1, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 3, 1}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 1, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 2, 1}, arr.getArray());
        arr.next();
    }

    public void testArray4() {
        RtNorepArray arr = new RtNorepArray(4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{1, 2, 4, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{1, 3, 2, 4}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{1, 3, 4, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{1, 4, 2, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{1, 4, 3, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 1, 3, 4}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 1, 4, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 3, 1, 4}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 3, 4, 1}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 4, 1, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{2, 4, 3, 1}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 1, 2, 4}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 1, 4, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 2, 1, 4}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 2, 4, 1}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 4, 1, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{3, 4, 2, 1}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{4, 1, 2, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{4, 1, 3, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{4, 2, 1, 3}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{4, 2, 3, 1}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{4, 3, 1, 2}, arr.getArray());
        arr.next();
        assertArrayEquals(new int[]{4, 3, 2, 1}, arr.getArray());
        arr.next();
    }
}