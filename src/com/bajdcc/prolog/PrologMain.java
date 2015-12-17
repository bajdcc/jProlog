package com.bajdcc.prolog;

import com.bajdcc.ast.block.IBlock;
import com.bajdcc.grammar.*;
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
        out = PrologExecutor.getInstance().getOut();
        PrologLexer lexer = new PrologLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PrologParser parser = new PrologParser(tokens);
        PrologParser.StartContext tree = parser.start();
        PrologVisitor<AstStruct> mv = new PrologBaseVisitorImpl();
        AstStruct ast = mv.visit(tree);
        block = ast.getBlock();
        out.println(ast.getBlock());
        out.println();
    }

    public void run() {

    }
}
