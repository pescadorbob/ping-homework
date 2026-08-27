package com.brent.ping.expressions;

/**
 * IsPresentExpression
 */
public class IsPresentExpression implements Expression {

    private String property;

    public IsPresentExpression(String property) {
        this.property = property;
        
    }

    public String getProperty() {
        return property;
    }

}
