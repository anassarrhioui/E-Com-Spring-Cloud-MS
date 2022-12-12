package me.arrhioui.billingservice.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@Configuration
public class SecretsPublisher {

    @Bean
    public CommandLineRunner publishPair(VaultTemplate vaultTemplate) {
        return args -> vaultTemplate.opsForVersionedKeyValue("secret")
                .put("keys", Map.of(
                        "publicKey", "I'm a public key",
                        "privateKey", "I'm a private key"
                ));
    }
}
