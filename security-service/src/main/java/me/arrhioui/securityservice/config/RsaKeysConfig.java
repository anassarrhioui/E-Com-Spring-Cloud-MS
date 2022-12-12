package me.arrhioui.securityservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties("rsa")
@Getter
@Setter
@AllArgsConstructor
public class RsaKeysConfig {
    private RSAPublicKey rsaPublicKey;
    private RSAPrivateKey rsaPrivateKey;
}
