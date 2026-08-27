package com.brent.ping;

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
