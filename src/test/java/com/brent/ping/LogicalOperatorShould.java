package com.brent.ping;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static com.brent.ping.ResourceTestBuilder.aResource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LogicalOperatorShould {

    @Test    
    void testLogicalOperator(){
        
        var lhs = new BooleanExpression("isActive", true);
        var rhs = new BooleanExpression("isEnabled", false);
        var logicalOperator = new LogicalOperator(LogicalOperatorType.AND);
        var binomialExpression = new BinomialExpression(lhs, logicalOperator, rhs);
        var resource = aResource().withProperty("isActive","true").withProperty("isEnabled","false").build();
        var filter = new Filter(binomialExpression);
        var expectedResult = true;

        var actual = filter.matches(resource);

        assertThat(actual).as("isActive AND not isEnabled").isEqualTo(expectedResult);
    }

    
}
