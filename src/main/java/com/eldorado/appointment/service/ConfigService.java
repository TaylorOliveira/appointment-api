package com.eldorado.appointment.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    private final Environment env;

    public ConfigService(Environment env) {
        this.env = env;
    }

    @Cacheable(cacheNames = "ConfigService", key = "#key + '-string'")
    public String getString(final String key) {
        return env.getProperty(key);
    }
}
