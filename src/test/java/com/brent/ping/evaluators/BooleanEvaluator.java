package com.brent.ping.evaluators;

import com.brent.ping.Resource;
import com.brent.ping.expressions.BooleanExpression;
import com.brent.ping.expressions.Expression;

/**
 * BooleanEvaluator
 */
public class BooleanEvaluator<T extends Comparable<T>> implements Evaluator<T> {

    @Override
    public boolean evaluate(Resource resource, Expression expression) {
        if(expression instanceof BooleanExpression) {
            BooleanExpression booleanExpression = (BooleanExpression) expression;
            String property = booleanExpression.getProperty();
            Boolean expectedValue = booleanExpression.getExpectedValue();
            Boolean actualValue = Boolean.parseBoolean(resource.getProperty(property));
            return expectedValue.equals(actualValue);
        }
        throw new IllegalArgumentException("Expression must be of type BooleanExpression");
    }

}
