package com.bajdcc.prolog;

import com.bajdcc.rt.IRtQueryAnswer;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.concurrent.Future;

/**
 * 执行程序
 */
public class PrologExecutor {
    private static final PrologExecutor ourInstance = new PrologExecutor();
    private PrintStream out = System.out;
    private Future<Object> future;

    private PrologExecutor() {
    }

    public static PrologExecutor getInstance() {
        return ourInstance;
    }

    public synchronized PrintStream getOut() {
        return out;
    }

    public synchronized void setOut(PrintStream out) {
        this.out = out;
    }

    public synchronized Future<Object> getFuture() {
        return future;
    }

    public synchronized void setFuture(Future<Object> future) {
        this.future = future;
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
