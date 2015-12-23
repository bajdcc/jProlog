package com.bajdcc.prolog;

import com.bajdcc.ast.block.IBlock;
import com.bajdcc.grammar.*;
import com.bajdcc.rt.IRtQueryAnswer;
import com.bajdcc.rt.RtBlock;
import com.bajdcc.rt.RtMachine;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;

/**
 * 解析和编译
 */
public class PrologMain {

    private PrintStream out;
    private IBlock block;
    private boolean debug = false;

    public PrologMain(boolean debug, String text) throws Exception {
        this.debug = debug;
        parse(new ANTLRInputStream(text));
    }

    public PrologMain(boolean debug, InputStream is) throws Exception {
        this.debug = debug;
        parse(new ANTLRInputStream(is));
    }

    public PrologMain(boolean debug, Reader r) throws Exception {
        this.debug = debug;
        parse(new ANTLRInputStream(r));
    }

    private void parse(ANTLRInputStream stream) throws Exception {
        this.out = PrologExecutor.getInstance().getOut();
        this.out.println(">> 调试: " + debug);
        this.out.println(">> 正在解析...");
        PrologLexer lexer = new PrologLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PrologParser parser = new PrologParser(tokens);
        PrologParser.StartContext tree = parser.start();
        PrologVisitor<AstStruct> mv = new PrologBaseVisitorImpl();
        AstStruct ast = mv.visit(tree);
        this.block = ast.getBlock();
        if (debug) {
            this.out.println(ast.getBlock());
            this.out.println();
        }
    }

    public IRtQueryAnswer run() throws Exception {
        return running(refactor());
    }

    private RtBlock refactor() throws Exception {
        this.out.println(">> 重构语法树...");
        RtBlock rtBlock = new RtBlock();
        block.visit(rtBlock);
        this.out.println(">> 语义检查...");
        rtBlock.visitAgain();
        return rtBlock;
    }

    private IRtQueryAnswer running(RtBlock rtBlock) throws Exception {
        this.out.println(">> 构建运行时...");
        RtMachine machine = new RtMachine(rtBlock, debug);
        this.out.println(">> 开始运行...");
        IRtQueryAnswer query = machine.run();
        this.out.println(">> 运行结束.");
        this.out.println();
        this.out.println();
        return query;
    }
}
