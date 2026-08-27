package com.brent.ping;

import com.brent.ping.evaluators.BinomialEvaluator;
import com.brent.ping.evaluators.BooleanEvaluator;
import com.brent.ping.evaluators.IsPresentEvaluator;
import com.brent.ping.expressions.BinomialExpression;
import com.brent.ping.expressions.BooleanExpression;
import com.brent.ping.expressions.IsPresentExpression;

/**
 * EvaluationRegistryFactory
 */
public class EvaluationRegistryFactory {

    public static EvaluationRegistry createRegistry() {
        var registry = new EvaluationRegistry();
        registry.registerEvaluator(IsPresentExpression.class,new IsPresentEvaluator());
        registry.registerEvaluator(BooleanExpression.class, new BooleanEvaluator());
        registry.registerEvaluator(BinomialExpression.class, new BinomialEvaluator(registry));
        return registry;
    }

}
