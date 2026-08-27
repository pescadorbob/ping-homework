package com.brent.ping;

import com.brent.ping.expressions.Expression;

/**
 * ComparisonExpression
 */
public class ComparisonExpression implements Expression {

    private String filterPropertyName;
    private ComparisonOperatorType operatorType;
    private String filterPropertyValue;

    public ComparisonExpression(String filterPropertyName, ComparisonOperatorType operatorType,
            String filterPropertyValue) {
                this.filterPropertyName = filterPropertyName;
                this.operatorType = operatorType;
                this.filterPropertyValue = filterPropertyValue;
        
    }
    public String getFilterPropertyName() {
        return filterPropertyName;
    }
    public ComparisonOperatorType getOperatorType() {
        return operatorType;
    }
    public String getFilterPropertyValue() {
        return filterPropertyValue;
    }

}
