package com.bajdcc.prolog;

import com.bajdcc.rt.IRtQueryAnswer;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.FileReader;

/**
 * 测试
 */
public class MathTest extends TestCase {

    public void testMazeOfArmstrong() throws Exception {

        // 水仙花数
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/math/armstrong3.txt"));
        int[][] mat = new int[][]{
                {3, 7, 0},
                {3, 7, 1},
                {1, 5, 3},
                {4, 0, 7}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(mat[i][j], query.queryValue(i, "" + ((char) ('A' + j)), null));
            }
        }
    }

    public void testMazeOfGougu() throws Exception {

        // 勾股数
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/math/gougu.txt"));
        int[][] mat = new int[][]{
                {3, 4, 5},
                {6, 8, 10},
                {5, 12, 13},
                {9, 12, 15},
                {8, 15, 17},
                {12, 16, 20},
        };
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(mat[i][j], query.queryValue(i, "" + ((char) ('A' + j)), null));
            }
        }
    }
}