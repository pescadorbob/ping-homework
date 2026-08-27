package com.brent.ping;

/**
 * EvaluationRegistryFactory
 */
public class EvaluationRegistryFactory {

    public static EvaluationRegistry createRegistry() {
        var registry = new EvaluationRegistry();
        registry.registerEvaluator(IsPresentExpression.class,new IsPresentEvaluator());
        registry.registerEvaluator(BooleanExpression.class, new BooleanEvaluator());
        
        return registry;
    }

}
