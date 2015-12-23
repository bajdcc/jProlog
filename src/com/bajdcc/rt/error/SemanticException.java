package com.bajdcc.rt.error;

/**
 * 语义错误
 */
public class SemanticException extends Exception {

    private final SemanticErrorType type;
    private final Object info;

    public SemanticException(Object info, String message, SemanticErrorType type) {
        super(message);
        this.type = type;
        this.info = info;
    }

    public SemanticErrorType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s #%s# \"%s\"", super.toString(), type.getName(), info);
    }

    public enum SemanticErrorType {

        REDECL("重复定义"),
        UNDECL("未定义"),
        NETYPE("类型不一致"),
        ERANGE("范围非法"),
        ETOKEN("表达式无意义"),
        EPARAM("参数非法"),
        ENIMPL("尚未实现"),
        ENOANS("无可用解");

        private String name;

        SemanticErrorType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
