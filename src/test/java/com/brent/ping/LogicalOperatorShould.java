package com.brent.ping;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static com.brent.ping.ResourceTestBuilder.aResource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LogicalOperatorShould {

    @ParameterizedTest(name = " {0} when x={1} applied to {2}")
    @MethodSource("testCases")
    void testLogicalOperator(String lhsProperty, Boolean lhsValue,
        String rhsProperty, Boolean rhsValue, LogicalOperatorType operatorType, 
        String resourceProperty1, String resourceValue1,
        String resourceProperty2, String resourceValue2,
        Boolean expectedResult, String description
    ){
        
        var lhs = new BooleanExpression(lhsProperty, lhsValue);
        var rhs = new BooleanExpression(rhsProperty, rhsValue);
        var logicalOperator = new LogicalOperator(operatorType);
        var binomialExpression = new BinomialExpression(lhs, logicalOperator, rhs);
        var resource = aResource().withProperty(resourceProperty1,resourceValue1).withProperty(resourceProperty2,resourceValue2).build();
        var filter = new Filter(binomialExpression);

        var actual = filter.matches(resource);

        assertThat(actual).as(description).isEqualTo(expectedResult);
    }
    private static Stream<Arguments> testCases() {
        return Stream.of(
                arguments("isActive", true, "isEnabled", false, LogicalOperatorType.AND, 
                "isActive","true","isEnabled","false",true,"FILTER:isActive AND not isEnabled, RESOURCE:isActive=true AND isEnabled=false, EXPECTED: true"),
                arguments("isActive", true, "isEnabled", true, LogicalOperatorType.AND,
                "isActive","true","isEnabled","false",false,"FILTER:isActive AND isEnabled, RESOURCE:isActive=true AND isEnabled=false, EXPECTED: false")
        );
    }
    
}
