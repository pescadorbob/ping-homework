package com.brent.ping;

import com.brent.ping.evaluators.BinomialEvaluator;
import com.brent.ping.evaluators.BooleanEvaluator;
import com.brent.ping.evaluators.IsPresentEvaluator;
import com.brent.ping.evaluators.LogicalEvaluator;
import com.brent.ping.expressions.BinomialExpression;
import com.brent.ping.expressions.BooleanExpression;
import com.brent.ping.expressions.IsPresentExpression;
import com.brent.ping.operator.LogicalOperator;

/**
 * EvaluationRegistryFactory
 */
public class EvaluationRegistryFactory {

    public static EvaluationRegistry createRegistry() {
        var registry = new EvaluationRegistry();
        registry.registerEvaluator(IsPresentExpression.class,new IsPresentEvaluator());
        registry.registerEvaluator(BooleanExpression.class, new BooleanEvaluator());
        registry.registerEvaluator(BinomialExpression.class, new BinomialEvaluator(registry));
        registry.registerEvaluator(ComparisonExpression.class, new ComparisonEvaluator());
        return registry;
    }

}
