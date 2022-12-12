package me.arrhioui.billingservice.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Getter
@Setter
public class ConsulConfig {

    private long accessTokenTimeout;

    private long refreshTokenTimeout;
}
