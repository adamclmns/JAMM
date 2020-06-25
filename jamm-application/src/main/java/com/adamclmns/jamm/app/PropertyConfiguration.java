package com.adamclmns.jamm.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * The type Property configuration.
 */
public class PropertyConfiguration {

    private static Logger log = LoggerFactory.getLogger(PropertyConfiguration.class);
    private final Properties cachedSystemConfig;

    /**
     * Instantiates a new Property configuration.
     *
     * @throws IOException the io exception
     */
    public PropertyConfiguration() throws IOException {
        this.cachedSystemConfig = new Properties();
        readDefaultProperties().forEach(this.cachedSystemConfig::put);
        System.getenv().forEach(this.cachedSystemConfig::put);
    }

    /**
     * Instantiates a new Property configuration.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public PropertyConfiguration(String... path) throws IOException {
        this();
        for (String p : path) {
            this.cachedSystemConfig.load(
                    Objects.requireNonNull(
                            getClass().getClassLoader().getResourceAsStream(p)));
        }
    }

    private Properties readDefaultProperties() throws IOException {
        Properties props = new Properties();
        props.load(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResourceAsStream("application.properties")));
        props.forEach((k, v) -> {
            log.debug("PROPERTY [{}] WITH VALUE [{}]", k, v);
        });
        return props;
    }

    private Object getPropertyByName(String propertyName) {
        return this.cachedSystemConfig.get(propertyName);
    }


}
