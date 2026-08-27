package com.brent.ping;

import com.brent.ping.evaluators.Evaluator;
import com.brent.ping.expressions.Expression;

/**
 * ComparisonEvaluator
 */
public class ComparisonEvaluator<T extends Comparable<T>> implements Evaluator<T> {

    @Override
    public boolean evaluate(Resource resource, Expression expression) {
        if(expression instanceof ComparisonExpression) {
            ComparisonExpression comparisonExpression = (ComparisonExpression) expression;
            String propertyName = comparisonExpression.getFilterPropertyName();
            ComparisonOperatorType operatorType = comparisonExpression.getOperatorType();
            String filterPropertyValue = comparisonExpression.getFilterPropertyValue();

            String resourcePropertyValue = resource.getProperty(propertyName);

            if (resourcePropertyValue == null) {
                return false; // Property not present in the resource
            }

            int comparisonResult = resourcePropertyValue.compareTo(filterPropertyValue);

            switch (operatorType) {
                case EQUALS:
                    return comparisonResult == 0;
                case NOT_EQUALS:
                    return comparisonResult != 0;
                case GREATER_THAN:
                    return comparisonResult > 0;
                case LESS_THAN:
                    return comparisonResult < 0;
                case GREATER_THAN_OR_EQUALS:
                    return comparisonResult >= 0;
                case LESS_THAN_OR_EQUALS:
                    return comparisonResult <= 0;
                default:
                    throw new IllegalArgumentException("Unsupported operator type: " + operatorType);
            }
        }

        throw new IllegalArgumentException("Expression must be an instance of ComparisonExpression");
    }

}
