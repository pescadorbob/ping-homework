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

    @ParameterizedTest(name = "{5} with filter property name {0}, operator type {1}, filter property value {2}, resource property name {3}, resource property value {4}")
    @MethodSource("testCases")
    void testComparisonOperator(String filterPropertyName, ComparisonOperatorType operatorType, String filterPropertyValue,
            String resourceProperty1, String resourceValue1,    
        Boolean expectedResult, String description
    ){
        var comparisonExpression = new ComparisonExpression(filterPropertyName, operatorType, filterPropertyValue);

        var resource = aResource().withProperty(resourceProperty1,resourceValue1).build();
        var filter = new Filter(comparisonExpression);

        var actual = filter.matches(resource);

        assertThat(actual).as(description).isEqualTo(expectedResult);
    }
    private static Stream<Arguments> testCases() {
        return Stream.of(
                arguments("age", ComparisonOperatorType.EQUALS, "35",
                "age","35",true,"FILTER:age EQUALS 35, RESOURCE:age=35, EXPECTED: true"),
                arguments("age", ComparisonOperatorType.EQUALS, "35",
                "age","36",false,"FILTER:age EQUALS 35, RESOURCE:age=36, EXPECTED: false"),
                arguments("age", ComparisonOperatorType.NOT_EQUALS, "35",
                "age","36",true,"FILTER:age != 35, RESOURCE:age=35, EXPECTED: false"),
                arguments("age", ComparisonOperatorType.NOT_EQUALS, "35",
                "age","35",false,"FILTER:age != 35, RESOURCE:age=35, EXPECTED: false"),
                arguments("age", ComparisonOperatorType.GREATER_THAN, "35",
                "age","36",true,"FILTER:age > 35, RESOURCE:age=36, EXPECTED: true"),
                arguments("age", ComparisonOperatorType.GREATER_THAN, "35",
                "age","34",false,"FILTER:age > 35, RESOURCE:age=34, EXPECTED: false"),
                arguments("age", ComparisonOperatorType.LESS_THAN, "35",
                "age","34",true,"FILTER:age < 35, RESOURCE:age=34, EXPECTED: true"),
                arguments("age", ComparisonOperatorType.LESS_THAN, "35",
                "age","36",false,"FILTER:age < 35, RESOURCE:age=36, EXPECTED: false")
        );
    }
    
}
