package com.brent.ping;

import java.util.Map;

public class Resource {

    private Map<String, String> properties;

    public Resource(Map<String, String> properties) {
        this.properties = properties;
        
    }
    public boolean hasProperty(String property) {
        return properties.containsKey(property);
    }
    public String getProperty(String property) {
        return properties.get(property);
        
    }
    
}
