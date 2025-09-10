package com.mcp.middleware.demo.whitelist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create by KG
 */
@ConfigurationProperties("mcp.whitelist")
public class WhiteListProperties {

    private String users;

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }
}
