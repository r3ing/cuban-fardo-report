package com.cubanfardo.cubanfardoreport.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("auth")
public record AuthConfigProperties(String username, String password) {
}
