package com.bajdcc.rt.symbol;

import com.bajdcc.rt.error.SemanticException;

import java.util.*;

/**
 * 字串工厂
 */
public class RtStringFactory {

    private List<Val> strList = new ArrayList<>();
    private Map<String, Integer> strMap = new HashMap<>();

    public int query(String str, ValType val) throws SemanticException {
        if (contains(str)) {
            Val old = strList.get(strMap.get(str));
            if (old.contains(val)) {
                return old.getId();
            }
        }
        throw new SemanticException(str, "对象不存在", SemanticException.SemanticErrorType.UNDECL);
    }

    public boolean contains(String str) {
        return strMap.containsKey(str);
    }

    public boolean containsVar(String str) {
        if (contains(str)) {
            Val old = strList.get(strMap.get(str));
            return !old.containsOnly(ValType.LITERAL);
        }
        return false;
    }

    public ValType getVarType(String str) {
        if (contains(str)) {
            Val old = strList.get(strMap.get(str));
            if (old.contains(ValType.SINGLE)) {
                return ValType.SINGLE;
            }
            if (old.contains(ValType.SEQUENCE)) {
                return ValType.SEQUENCE;
            }
            if (old.contains(ValType.ARGUMENT)) {
                return ValType.ARGUMENT;
            }
        }
        return ValType.NONE;
    }

    public boolean add(String str, ValType val) {
        if (contains(str)) {
            Val old = strList.get(strMap.get(str));
            if (old.contains(val)) {
                return false;
            }
            old.add(val);
        }
        int id = strList.size();
        strMap.put(str, id);
        strList.add(new Val(id, val));
        return true;
    }

    public enum ValType {
        NONE,
        SET,
        LITERAL,
        SINGLE,
        SEQUENCE,
        ARGUMENT,
        TMPID,
    }

    private class Val {
        private final int id;
        private Set<ValType> set = new HashSet<>();

        public Val(int id, ValType val) {
            this.id = id;
            this.set.add(val);
        }

        public int getId() {
            return id;
        }

        public boolean contains(ValType val) {
            return set.contains(val);
        }

        public boolean containsOnly(ValType val) {
            return set.contains(val) && set.size() == 1;
        }

        public void add(ValType val) {
            set.add(val);
        }
    }
}
