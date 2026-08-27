package com.brent.ping;

/**
 * LogicalEvaluator
 */
public class LogicalEvaluator {

    private LogicalOperator operator;

    public LogicalEvaluator(LogicalOperator operator) {
        this.operator = operator;        
    }

    public boolean evaluate(boolean lhsResult, boolean rhsResult) {
        if(operator.getType() == LogicalOperatorType.AND) {
            return lhsResult && rhsResult;
        } else if(operator.getType() == LogicalOperatorType.OR) {
            return lhsResult || rhsResult;
        }
        throw new UnsupportedOperationException("Unsupported logical operator: " + operator.getType());
    }

}
