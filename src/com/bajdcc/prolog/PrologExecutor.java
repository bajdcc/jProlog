package com.bajdcc.prolog;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;

/**
 * 执行程序
 */
public class PrologExecutor {
    private static PrologExecutor ourInstance = new PrologExecutor();
    private PrintStream out = System.out;

    private PrologExecutor() {
    }

    public static PrologExecutor getInstance() {
        return ourInstance;
    }

    public PrintStream getOut() {
        return out;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void run(String text) throws Exception {
        new PrologMain(text).run();
    }

    public void run(InputStream is) throws Exception {
        new PrologMain(is).run();
    }

    public void run(Reader r) throws Exception {
        new PrologMain(r).run();
    }
}
