package com.bajdcc.prolog;

import com.bajdcc.rt.IRtQueryAnswer;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;

/**
 * 执行程序
 */
public class PrologExecutor {
    private static final PrologExecutor ourInstance = new PrologExecutor();
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

    public IRtQueryAnswer runWithDebug(String text) throws Exception {
        return new PrologMain(true, text).run();
    }

    public IRtQueryAnswer runWithDebug(InputStream is) throws Exception {
        return new PrologMain(true, is).run();
    }

    public IRtQueryAnswer runWithDebug(Reader r) throws Exception {
        return new PrologMain(true, r).run();
    }

    public IRtQueryAnswer run(String text) throws Exception {
        return new PrologMain(false, text).run();
    }

    public IRtQueryAnswer run(InputStream is) throws Exception {
        return new PrologMain(false, is).run();
    }

    public IRtQueryAnswer run(Reader r) throws Exception {
        return new PrologMain(false, r).run();
    }
}
