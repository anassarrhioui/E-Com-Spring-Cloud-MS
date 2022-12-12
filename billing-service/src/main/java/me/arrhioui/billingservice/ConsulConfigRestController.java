package me.arrhioui.billingservice;


import lombok.AllArgsConstructor;
import me.arrhioui.billingservice.config.ConsulConfig;
import me.arrhioui.billingservice.config.VaultConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ConsulConfigRestController {

    private final ConsulConfig consulConfig;
    private final VaultConfig vaultConfig;

    @GetMapping
    public Map<String, Object> getConfig(){
        return Map.of(
                "accessTokenTimeout", consulConfig.getAccessTokenTimeout(),
                "refreshTokenTimeout", consulConfig.getRefreshTokenTimeout(),
                "username", vaultConfig.getUsername(),
                "password", vaultConfig.getPassword()
        );
    }
}
