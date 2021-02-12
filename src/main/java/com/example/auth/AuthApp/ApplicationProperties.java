package com.example.auth.AuthApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationProperties {

    @Autowired
    private Environment env;

    private String getConfigValue(String configKey) {
        return env.getProperty(configKey);
    }

    public String getSecretKey() {
        return getConfigValue("app.SECRET_KEY");
    }

    public Integer getJWTExpirationTime() {
        return Integer.parseInt(getConfigValue("app.JWT_EXPIRATION_TIME"));
    }

    public String getJWTHeaderPrefix() {
        return getConfigValue("app.JWT_HEADER_PREFIX");
    }

    public String getHeaderString() {
        return getConfigValue("app.HEADER_STRING");
    }

    public String getSignUpUrl() {
        return getConfigValue("app.SIGN_UP_URL");
    }
}
