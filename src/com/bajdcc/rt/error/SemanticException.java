package com.bajdcc.rt.error;

/**
 * 语义错误
 */
public class SemanticException extends Exception {

    private SemanticErrorType type;

    public SemanticException(String message, SemanticErrorType type) {
        super(message);
        this.type = type;
    }

    public SemanticErrorType getType() {
        return type;
    }

    public enum SemanticErrorType {

        REDECL("重复定义"),;

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
