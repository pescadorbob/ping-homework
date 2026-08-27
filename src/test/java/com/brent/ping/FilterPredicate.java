package com.brent.ping;

public class FilterPredicate {

    
    private IsPresentExpression expression;

    public FilterPredicate(IsPresentExpression expression) {
        this.expression = expression;
    }

    public boolean matches(Resource resource) {
        return evaluate(resource,expression);
        
    }
    public boolean evaluate(Resource resource, IsPresentExpression expression) {
        return resource.hasProperty(expression.getProperty());
    }
    
}
