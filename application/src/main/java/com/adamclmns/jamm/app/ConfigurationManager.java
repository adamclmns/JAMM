package com.adamclmns.jamm.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConfigurationManager {
    private static final String IGDB_API_KEY_PROPERTY = "IGDB_USER_KEY";
    private static final String IGDB_BASE_PATH = "igdb.base-url";
    private static Logger log = LoggerFactory.getLogger(ConfigurationManager.class);
    private final Properties CachedSystemConfig;

    public ConfigurationManager() throws IOException {
        this.CachedSystemConfig = new Properties();
        readDefaultProperties().forEach(this.CachedSystemConfig::put);
        System.getenv().forEach(this.CachedSystemConfig::put);
    }

    private Properties readDefaultProperties() throws IOException {
        Properties props = new Properties();
        props.load(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResourceAsStream("application.properties")));
        props.forEach((k, v) -> {
            log.info("PROPERTY [{}] WITH VALUE [{}]", k, v);
        });
        return props;
    }

    private Object getPropertyByName(String propertyName) {
        return this.CachedSystemConfig.get(propertyName);
    }

    public String getIgdbApiKey() {
        return String.valueOf(getPropertyByName(IGDB_API_KEY_PROPERTY));
    }

    public String getIgdbBasePath() {
        return String.valueOf(getPropertyByName(IGDB_BASE_PATH));
    }
}
