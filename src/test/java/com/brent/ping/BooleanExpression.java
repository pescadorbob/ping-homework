package com.brent.ping;

/**
 * BooleanExpression
 */
public class BooleanExpression implements Expression {

    private String filterProperty;
    private Boolean filterValue;

    public BooleanExpression(String filterProperty, Boolean filterValue) {
        this.filterProperty = filterProperty;
        this.filterValue = filterValue;
    }

    public String getProperty() {
        return this.filterProperty;        
    }

    public Boolean getExpectedValue() {
        return this.filterValue;        
    }

}
