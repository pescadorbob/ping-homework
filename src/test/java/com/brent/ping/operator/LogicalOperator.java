package com.brent.ping.operator;

import com.brent.ping.LogicalOperatorType;

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
