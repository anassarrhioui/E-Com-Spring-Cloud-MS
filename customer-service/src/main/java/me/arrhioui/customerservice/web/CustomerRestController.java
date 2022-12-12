package me.arrhioui.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/config")
@RefreshScope
public class CustomerRestController {

    @Value("${global.params.app-name}")
    private String appName;
    @Value("${global.params.app-version}")
    private String appVersion;
    @Value("${customer.params.x}")
    private String paramX;
    @Value("${customer.params.y}")
    private String paramY;


    @GetMapping
    public Map<String, String> getConfig(){
        return Map.of(
                "appName", appName,
                "appVersion", appVersion,
                "paramX", paramX,
                "paramY", paramY
                );
    }
}
