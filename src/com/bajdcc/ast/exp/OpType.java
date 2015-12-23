package com.bajdcc.ast.exp;

/**
 * 操作符
 */

public enum OpType {
    EQ("=", 0),
    NEQ("!=", -1),
    LT("<", -2),
    LTE("<=", -2),
    GT(">", -2),
    GTE(">=", -2),
    PLUS("+", 10),
    MINUS("-", 10),
    MUL("*", 20),
    DIV("/", 20),
    MOD("%", 18),
    NOT("!", 100),
    AND("&", 5),
    OR("|", 5),
    XOR("^", 6),
    IMPLY("->", 4),;

    private final String name;
    private final int adv;

    OpType(String name, int adv) {
        this.name = name;
        this.adv = adv;
    }

    public static boolean gte(OpType type1, OpType type2) {
        return type1 != null && (type2 == null ? true : type1.getAdv() >= type2.getAdv());
    }

    public String getName() {
        return name;
    }

    public int getAdv() {
        return adv;
    }
}
