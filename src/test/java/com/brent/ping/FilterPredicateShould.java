package com.brent.ping;

import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FilterPredicateShould {

    @Test
    void evaluateToTrue_givenUserWithNameAndPredicateWithIsPresent() {
        var user = aResource().withProperty("name", "John").build();
        var isPresentExpression = new IsPresentExpression("name");
        var filter = new FilterPredicate(isPresentExpression);
        var expected = true;

        var actual = filter.matches(user);

        assertThat(actual).isEqualTo(expected);
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
