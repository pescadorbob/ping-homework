package com.brent.ping;

import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.brent.ping.expressions.IsPresentExpression;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class IsPresentFilterShould {

    @ParameterizedTest(name = " {0} with given input {1}")
    @MethodSource("testCases")
    void evaluateToTrue_givenResourceWithProperty_Name_AndIsPresentFilter(boolean expectedResult, String property, String resourcePropertyName, String resourcePropertyValue, String description) {
        var resource = aResource().withProperty(resourcePropertyName, resourcePropertyValue).build();
        var isPresentExpression = new IsPresentExpression(property);
        var filter = new Filter(isPresentExpression);

        var actual = filter.matches(resource);

        assertThat(actual).as(description).isEqualTo(expectedResult);
    }
    private static Stream<Arguments> testCases() {
        return Stream.of(
                arguments(true,"name","name","John","name to name"),
                arguments(false,"age","name","John","missing property"),
                arguments(false,"Age","age","30","Filter: Property name is case sensitive"),
                arguments( false,"age","Age","30","Resource: Property name is case sensitive")
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
