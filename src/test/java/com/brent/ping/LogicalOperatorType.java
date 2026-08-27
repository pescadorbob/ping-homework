package com.brent.ping;

/**
 * LogicalOperatorType
 */
public enum LogicalOperatorType {
    AND("AND");

    private final String symbol;

    LogicalOperatorType(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
    

}
