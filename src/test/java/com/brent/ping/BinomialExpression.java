package com.brent.ping;

/**
 * BinomialExpression
 */
public class BinomialExpression implements Expression {

    private Expression lhs;  
    private LogicalOperator logicalOperator;
    private Expression rhs;

    public BinomialExpression(Expression lhs, LogicalOperator logicalOperator, Expression rhs) {
        this.lhs = lhs;
        this.logicalOperator = logicalOperator;
        this.rhs = rhs;    
    }

    public Expression getLhs() {
        return lhs;        
    }

    public Expression getRhs() {
        return rhs;
    }

    public LogicalOperator getLogicalOperator() {
        return logicalOperator;
    }

}
