package com.brent.ping;

/**
 * BinomialEvaluator
 */
public class BinomialEvaluator<T extends Comparable<T>> implements Evaluator<T> {

    private EvaluationRegistry<T> registry;

    public BinomialEvaluator(EvaluationRegistry<T> registry) {
        this.registry = registry;
    }

    @Override
    public boolean evaluate(Resource resource, Expression expression) {
        if (expression instanceof BinomialExpression) {
            BinomialExpression binomialExpression = (BinomialExpression) expression;
            var lhs = binomialExpression.getLhs();
            var operator = binomialExpression.getLogicalOperator();
            var rhs = binomialExpression.getRhs();

            var operatorEvaluator = new LogicalEvaluator(operator);

            Evaluator<T> lhsEvaluator = registry.getEvaluator(lhs);
            Evaluator<T> rhsEvaluator = registry.getEvaluator(rhs);

            boolean lhsResult = lhsEvaluator.evaluate(resource, lhs);
            boolean rhsResult = rhsEvaluator.evaluate(resource, rhs);

            return operatorEvaluator.evaluate(lhsResult, rhsResult);
        }
        throw new IllegalArgumentException("Expression must be an instance of BinomialExpression");
    }

}
