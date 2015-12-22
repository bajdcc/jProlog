package com.bajdcc.rt.adv;

import com.bajdcc.rt.error.SemanticException;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合
 */
public class RtSetDef {

    private final int id;
    private SetType type = SetType.NONE;
    private Set<Integer> elements = new HashSet<>();

    public RtSetDef(int id) {
        this.id = id;
    }

    public void addInteger(int id) throws SemanticException {
        if (type == SetType.LITERAL) {
            throw new SemanticException("当前集合是数字，而输入为字串", "集合数据类型不一致", SemanticException.SemanticErrorType.NETYPE);
        }
        if (type == SetType.NONE) {
            type = SetType.NUMBER;
        }
        if (elements.contains(id)) {
            throw new SemanticException(id, "集合数字重复定义", SemanticException.SemanticErrorType.REDECL);
        }
        elements.add(id);
    }

    public void addLiteral(int id) throws SemanticException {
        if (type == SetType.NUMBER) {
            throw new SemanticException("当前集合是字串，而输入为数字", "集合数据类型不一致", SemanticException.SemanticErrorType.NETYPE);
        }
        if (type == SetType.NONE) {
            type = SetType.LITERAL;
        }
        if (elements.contains(id)) {
            throw new SemanticException(id, "集合字串重复定义", SemanticException.SemanticErrorType.REDECL);
        }
        elements.add(id);
    }

    public int getId() {
        return id;
    }

    private enum SetType {
        NONE,
        LITERAL,
        NUMBER
    }
}
