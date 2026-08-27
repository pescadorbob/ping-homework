package com.brent.ping;

/**
 * Evaluator
 */
public interface Evaluator<T extends Comparable<T>> {

    boolean evaluate(Resource resource, Expression expression);

}
