package com.brent.ping;

import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FilterPredicateShould {

    @ParameterizedTest(name = " {0} with given input {1}")
    @MethodSource("testCases")
    void evaluateToTrue_givenUserWithNameAndPredicateWithIsPresent(boolean expectedResult, String property) {
        var user = aResource().withProperty("name", "John").build();
        var isPresentExpression = new IsPresentExpression(property);
        var filter = new FilterPredicate(isPresentExpression);

        var actual = filter.matches(user);

        assertThat(actual).isEqualTo(expectedResult);
    }
    private static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(true,"name"),
                arguments(false,"age")
        );
    }

    private static ResourceTestBuilder aResource() {
        return new ResourceTestBuilder();
    }
    private static class ResourceTestBuilder {
        private final Map<String, String> properties;

        public ResourceTestBuilder() {
            this.properties = new java.util.HashMap<>();
        }

        public ResourceTestBuilder withProperty(String key, String value) {
            properties.put(key, value);
            return this;
        }

        public Resource build() {
            return new Resource(properties);
        }
    }
}
