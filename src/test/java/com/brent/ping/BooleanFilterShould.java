package com.brent.ping;

import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BooleanFilterShould {

    @ParameterizedTest(name = " {0} with given input {1}")
    @MethodSource("testCases")
    void testBoolean(boolean expectedResult, 
        String filterProperty, Boolean filterValue, 
        String resourcePropertyName, String resourcePropertyValue, 
        String description) {
        var resource = aResource().withProperty(resourcePropertyName, resourcePropertyValue).build();
        var booleanExpression = new BooleanExpression(filterProperty, filterValue);
        var filter = new Filter(booleanExpression);

        var actual = filter.matches(resource);

        assertThat(actual).as(description).isEqualTo(expectedResult);
    }
    private static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(true,"isActive",true,"isActive","true","resource is Active")
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
