package com.bajdcc;

import com.bajdcc.grammar.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

public class Main {

    public static void main(String[] args) {

        String text = "所有人{} = {\"埃夫里\",\"布莱克\",\"克朗\",\"戴维斯\",\"其他人\"};\n" +
                "时间{} = {1,2,3,4};\n" +
                "时间 死亡时刻;\n" +
                "时间 在寓所(所有人);\n" +
                "所有人 凶手;\n" +
                "\n" +
                "时间 辅助变量[];                 //使用辅助变量保证每个人的在寓所时间不同\n" +
                "辅助变量[1] = 在寓所(\"埃夫里\");\n" +
                "辅助变量[2] = 在寓所(\"布莱克\");\n" +
                "辅助变量[3] = 在寓所(\"克朗\");\n" +
                "辅助变量[4] = 在寓所(\"戴维斯\");\n" +
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
            ANTLRInputStream input = new ANTLRInputStream(text);
            PrologLexer lexer = new PrologLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PrologParser parser = new PrologParser(tokens);
            PrologParser.StartContext tree = parser.start();
            PrologVisitor<AstStruct> mv = new PrologBaseVisitorImpl();
            AstStruct ast = mv.visit(tree);
            System.out.println(ast.getBlock());
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
