package com.brent.ping;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.brent.ping.expressions.BinomialExpression;
import com.brent.ping.expressions.BooleanExpression;
import com.brent.ping.operator.LogicalOperator;

import static com.brent.ping.ResourceTestBuilder.aResource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ComparisonOperatorShould {

    @ParameterizedTest(name = " {0} when x={1} applied to {2}")
    @MethodSource("testCases")
    void testComparisonOperator(String filterPropertyName, ComparisonOperatorType operatorType, String filterPropertyValue,
            String resourceProperty1, String resourceValue1,    
        Boolean expectedResult, String description
    ){
        var logicalExpression = new LogicalExpression(filterPropertyName, operatorType, filterPropertyValue);

        var resource = aResource().withProperty(resourceProperty1,resourceValue1).withProperty(resourceProperty2,resourceValue2).build();
        var filter = new Filter(logicalExpression);

        var actual = filter.matches(resource);

        assertThat(actual).as(description).isEqualTo(expectedResult);
    }
    private static Stream<Arguments> testCases() {
        return Stream.of(
                arguments("age", ComparisonOperatorType.EQUALS, "35",
                "age","35",true,"FILTER:age EQUALS 35, RESOURCE:age=35, EXPECTED: true")
        );
    }
    
}
