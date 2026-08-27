package com.brent.ping;

/**
 * LogicalOperator
 */
public class LogicalOperator {

    private LogicalOperatorType operatorType;

    public LogicalOperator(LogicalOperatorType operatorType) {
        this.operatorType = operatorType;        
    }

    public LogicalOperatorType getType() {
        return operatorType;
    }

}
