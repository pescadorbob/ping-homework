package com.brent.ping;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.brent.ping.expressions.BinomialExpression;
import com.brent.ping.expressions.BooleanExpression;
import com.brent.ping.expressions.ComparisonExpression;
import com.brent.ping.operator.LogicalOperator;

import static com.brent.ping.ResourceTestBuilder.aResource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArbitrarilyComplexFilterShould {

    @Test
    void evaluateSeveralLevelsOfExpressions() {
        var lhs = new BinomialExpression(
            new ComparisonExpression("age",ComparisonOperatorType.EQUALS,"30"), 
            new LogicalOperator(LogicalOperatorType.AND), 
            new ComparisonExpression("weight",ComparisonOperatorType.LESS_THAN,"220"));
        var logicalOperator = new LogicalOperator(LogicalOperatorType.AND);
        var rhs = new BooleanExpression("isActive", true );
        var fullExpression = new BinomialExpression(lhs, logicalOperator, rhs);
        var resource = aResource()
           .withProperty("name","John")
           .withProperty("age","30")
           .withProperty("weight","200")
           .withProperty("isActive","true")
           .build();
        var filter = new Filter(fullExpression);

        var actual = filter.matches(resource);

        assertThat(actual).as("Filter: (age=30 AND weight<220) AND isActive=true, Resource: (name=John, age=30, weight=200, isActive=true), EXPECTED: true").isEqualTo(true);
    }
    
}
