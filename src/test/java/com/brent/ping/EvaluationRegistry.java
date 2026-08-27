package com.brent.ping;

import java.util.HashMap;
import java.util.Map;

import com.brent.ping.evaluators.Evaluator;
import com.brent.ping.expressions.Expression;

/**
 * EvaluationRegistry
 */
public class EvaluationRegistry<T extends Comparable<T>>{ 

    private final Map<Class<? extends Expression>, Evaluator<T>> evaluators ;

    public EvaluationRegistry() {
        evaluators = new HashMap<>();
    }


    public Evaluator<T> getEvaluator(Expression expression) {
        var evaluator = evaluators.get(expression.getClass());
        if (evaluator != null) {
            return evaluator;
        }
        throw new IllegalArgumentException("No evaluator registered for expression type: " + expression.getClass().getName());
    }

    public void registerEvaluator(Class<? extends Expression> expressionClass, Evaluator<?> evaluator) {
        evaluators.put(expressionClass, (Evaluator<T>) evaluator);
        
    }

}
