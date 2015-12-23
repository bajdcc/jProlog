package com.bajdcc.prolog;

import com.bajdcc.rt.IRtQueryAnswer;
import junit.framework.TestCase;
import org.junit.Assert;

import java.io.FileReader;

/**
 * 测试
 */
public class PrologTest extends TestCase {

    public void testMazeOfLie1() throws Exception {

        // 个个撒谎
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/lie1.txt"));
        Assert.assertEquals("埃夫里", query.queryValue(0, "凶手", null));
    }

    public void testMazeOfLie2() throws Exception {

        // 个个撒谎
        // same as testLie1, but use sequence
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/lie2.txt"));
        Assert.assertEquals("埃夫里", query.queryValue(0, "凶手", null));
    }

    public void testMazeOfBestPlayer() throws Exception {

        // 最佳选手
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/best.txt"));
        Assert.assertEquals("女儿", query.queryValue(0, "最佳", null));
        Assert.assertEquals("妹妹", query.queryValue(0, "最差", null));
    }

    public void testMazeOfMrRight() throws Exception {

        // 白马王子
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/right.txt"));
        Assert.assertEquals("卡尔", query.queryValue(0, "白马王子", null));
    }

    public void TIMEDOUT_testMazeOfMurder() throws Exception {

        // 艾黎斯与谋杀案
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/murder.txt"));
        Assert.assertEquals("哥哥", query.queryValue(0, "people", new Object[]{4}));
    }

    public void TIMEDOUT_testMazeOfKing() throws Exception {

        // 王牌
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/king.txt"));
        Assert.assertEquals("黑桃", query.queryValue(0, "王牌", null));
    }

    public void testMazeOfScore() throws Exception {

        // 安东尼的名次
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/score.txt"));
        Assert.assertEquals(1, query.queryValue(0, "安杆", null));
    }

    public void TIMEDOUT_testMazeOfStock() throws Exception {

        // 父与子
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/stock.txt"));
        Assert.assertEquals("克", query.queryValue(0, "人", new Object[]{
                query.queryValue(0, "B1", null)
        }));
        Assert.assertEquals("丹", query.queryValue(0, "人", new Object[]{
                query.queryValue(0, "B4", null)
        }));
    }

    public void testMazeOfMurder2() throws Exception {

        // 祸起萧墙
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/murder2.txt"));
        Assert.assertEquals("母亲", query.queryValue(0, "凶手", null));
    }

    public void testMazeOfG6() throws Exception {

        // 6个G
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/g6.txt"));
        Assert.assertEquals(6, query.queryValue(0, "G", null));
    }

    public void testMazeOfLover() throws Exception {

        // 梦中情人
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/lover.txt"));
        Assert.assertEquals("阿", query.queryValue(0, "梦", null));
    }

    public void testMazeOfA3() throws Exception {

        // 3个A
        IRtQueryAnswer query = PrologExecutor.getInstance().runWithDebug(
                new FileReader("./tests/com/bajdcc/prolog/txt/a3.txt"));
        Assert.assertEquals(8, query.queryValue(0, "A", null));
    }
}