package com.brent.ping;

import com.brent.ping.expressions.Expression;

public class Filter {

    
    private Expression expression;
    private final EvaluationRegistry evaluationRegistry;

    public Filter(Expression expression) {
        this.expression = expression;
        evaluationRegistry = EvaluationRegistryFactory.createRegistry();

    }

    public boolean matches(Resource resource) {
        return evaluate(resource,expression);
        
    }
    public boolean evaluate(Resource resource, Expression expression) {
        var evaluator = evaluationRegistry.getEvaluator(expression);
        return evaluator.evaluate(resource, expression);
    }
    
}
