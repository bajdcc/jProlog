package com.bajdcc.prolog;

import com.bajdcc.ast.block.IBlock;
import com.bajdcc.grammar.*;
import com.bajdcc.rt.RtBlock;
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

    public PrologMain(String text) throws Exception {
        parse(new ANTLRInputStream(text));
    }

    public PrologMain(InputStream is) throws Exception {
        parse(new ANTLRInputStream(is));
    }

    public PrologMain(Reader r) throws Exception {
        parse(new ANTLRInputStream(r));
    }

    private void parse(ANTLRInputStream stream) throws Exception {
        this.out = PrologExecutor.getInstance().getOut();
        this.out.println("正在解析……");
        PrologLexer lexer = new PrologLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PrologParser parser = new PrologParser(tokens);
        PrologParser.StartContext tree = parser.start();
        PrologVisitor<AstStruct> mv = new PrologBaseVisitorImpl();
        AstStruct ast = mv.visit(tree);
        this.block = ast.getBlock();
        this.out.println(ast.getBlock());
        this.out.println();
    }

    public void run() throws Exception {
        refactor();
    }

    private void refactor() throws Exception {
        this.out.println("重构……");
        RtBlock rtBlock = new RtBlock();
        block.visit(rtBlock);
        rtBlock.visitAgain();
    }
}
