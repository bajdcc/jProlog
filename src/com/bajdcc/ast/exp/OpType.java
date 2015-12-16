package com.bajdcc.ast.exp;

/**
 * 操作符
 */
public enum OpType {

    EQ("="),
    NEQ("!="),
    LT("<"),
    LTE("<="),
    GT(">"),
    GTE(">="),
    PLUS("+"),
    MINUS("-"),
    MUL("*"),
    DIV("/"),
    MOD("%"),
    NOT("!"),
    AND("&"),
    OR("|"),
    XOR("^"),
    IMPLY("->"),;

    private String name;

    OpType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
