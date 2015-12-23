package com.bajdcc;

import com.bajdcc.prolog.PrologExecutor;
import com.bajdcc.rt.IRtQueryAnswer;

public class Main {

    public static void main(String[] args) {

        String text = "所有人{} = {\"埃夫里\",\"布莱克\",\"克朗\",\"戴维斯\",\"其他人\"};\n" +
                "时间{} = {1,2,3,4};\n" +
                "时间 死亡时刻;\n" +
                "时间 在寓所(所有人);\n" +
                "所有人 凶手;\n" +
                "\n" +
                "互斥(在寓所(\"埃夫里\"),在寓所(\"布莱克\"),在寓所(\"克朗\"),在寓所(\"戴维斯\"));\n" +
                "\n" +
                "在寓所(凶手) = 死亡时刻;\n" +
                "\n" +
                "凶手 != \"其他人\"; //(1)\n" +
                "在寓所(\"埃夫里\") >= 死亡时刻; //(2)\n" +
                "在寓所(\"布莱克\") != 2; //(3)\n" +
                "在寓所(\"布莱克\") <= 死亡时刻; //(4)\n" +
                "在寓所(\"克朗\") != 3; //(5)\n" +
                "在寓所(\"克朗\") >= 死亡时刻; //(6)\n" +
                "在寓所(\"戴维斯\") < 在寓所(凶手); //(7)\n" +
                "在寓所(\"戴维斯\") <= 死亡时刻; //(7)\n" +
                "\n" +
                "输出(\"凶手是: \",凶手);\n";
        try {
            IRtQueryAnswer query = PrologExecutor.getInstance().run(text);
            System.out.println();
            System.out.println("============= 查询接口 ==============");
            System.out.println(query.queryValue(0, "凶手", null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
