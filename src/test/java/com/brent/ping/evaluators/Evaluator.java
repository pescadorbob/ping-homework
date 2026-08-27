package com.brent.ping.evaluators;

import com.brent.ping.Resource;
import com.brent.ping.expressions.Expression;

/**
 * Evaluator
 */
public interface Evaluator<T extends Comparable<T>> {

    boolean evaluate(Resource resource, Expression expression);

}
