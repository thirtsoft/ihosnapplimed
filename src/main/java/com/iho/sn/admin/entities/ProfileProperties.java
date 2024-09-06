package com.iho.sn.admin.entities;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties()
@PropertySource("classpath:application.properties")
public class ProfileProperties {

    private String frontendUrlAccess;

    private String backendUrlAccess;

    private String senderName;

    public String getFrontendUrlAccess() {
        return frontendUrlAccess;
    }

    public void setFrontendUrlAccess(String frontendUrlAccess) {
        this.frontendUrlAccess = frontendUrlAccess;
    }

    public String getBackendUrlAccess() {
        return backendUrlAccess;
    }

    public void setBackendUrlAccess(String backendUrlAccess) {
        this.backendUrlAccess = backendUrlAccess;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
