package com.brent.ping.evaluators;

import com.brent.ping.Resource;
import com.brent.ping.expressions.Expression;
import com.brent.ping.expressions.IsPresentExpression;

/**
 * IsPresentEvaluator
 */
public class IsPresentEvaluator<T extends Comparable<T>> implements Evaluator<T> {

    @Override
    public boolean evaluate(Resource resource, Expression expression) {
        if(expression instanceof IsPresentExpression) {
            IsPresentExpression isPresentExpression = (IsPresentExpression) expression;
            return resource.hasProperty(isPresentExpression.getProperty());

        }
        throw new IllegalArgumentException("Expression must be an instance of IsPresentExpression");
    }

}
