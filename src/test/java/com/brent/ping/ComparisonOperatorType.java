package com.brent.ping;

/**
 * ComparisonOperatorType
 */
public enum ComparisonOperatorType {
    EQUALS("=="),
    NOT_EQUALS("!="),
    GREATER_THAN(">"),
    LESS_THAN("<"),
    GREATER_THAN_OR_EQUALS(">="),
    LESS_THAN_OR_EQUALS("<=");

    private String operator;

    ComparisonOperatorType(String operator) {
        this.operator = operator;
    }
    public String getOperator() {
        return operator;
    }

}
