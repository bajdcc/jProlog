package com.bajdcc.rt.symbol;

import com.bajdcc.rt.error.SemanticException;

import java.util.*;

/**
 * 字串工厂
 */
public class RtStringFactory {

    private final List<Val> strList = new ArrayList<>();
    private final Map<String, Integer> strMap = new HashMap<>();

    public int query(String str, ValType val) throws SemanticException {
        if (contains(str)) {
            Val old = strList.get(strMap.get(str));
            if (old.contains(val)) {
                return old.getId();
            }
        }
        throw new SemanticException(str, "对象不存在", SemanticException.SemanticErrorType.UNDECL);
    }

    public int query(String str, ValType[] val) throws SemanticException {
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
            return old.contains(ValType.SINGLE) ||
                    old.contains(ValType.SEQUENCE) ||
                    old.contains(ValType.ARGUMENT);
        }
        return false;
    }

    public ValType getVarType(String str) {
        if (contains(str)) {
            Val old = strList.get(strMap.get(str));
            final ValType[] typeList = new ValType[]{
                    ValType.SINGLE,
                    ValType.SEQUENCE,
                    ValType.ARGUMENT,
                    ValType.LITERAL,
            };
            for (ValType type : typeList) {
                if (old.contains(type)) {
                    return type;
                }
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
        } else {
            int id = strList.size();
            strMap.put(str, id);
            strList.add(new Val(id, str, val));
        }
        return true;
    }

    public String export(int id) {
        return strList.get(id).getString();
    }

    private class Val {
        private final int id;
        private final String string;
        private final Set<ValType> set = new HashSet<>();

        public Val(int id, String string, ValType val) {
            this.id = id;
            this.string = string;
            this.set.add(val);
        }

        public int getId() {
            return id;
        }

        public String getString() {
            return string;
        }

        public boolean contains(ValType val) {
            return set.contains(val);
        }

        public boolean contains(ValType[] val) {
            for (ValType type : val) {
                if (set.contains(type)) {
                    val[0] = type;
                    return true;
                }
            }
            return false;
        }

        public boolean containsOnly(ValType val) {
            return set.contains(val) && set.size() == 1;
        }

        public void add(ValType val) {
            set.add(val);
        }
    }
}
