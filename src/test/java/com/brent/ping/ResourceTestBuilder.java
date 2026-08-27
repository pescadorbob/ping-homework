package com.brent.ping;

import java.util.Map;

class ResourceTestBuilder {
    private final Map<String, String> properties;

    public static ResourceTestBuilder aResource() {
        return new ResourceTestBuilder();
    }
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