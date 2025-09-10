package com.mcp.lab.mq.rabbit.common.domain;

import lombok.Getter;

/**
 * @author: KG
 * @description: 连接信息(带构造器)
 * @date: Created in 2021年04月15日 10:10 AM
 * @modified by:
 */
@Getter
public class ConnInfo {
    private String host;
    private int port;
    private String virtualHost;
    private String username;
    private String password;

    private ConnInfo() {
    }

    // Builder中使用
    protected ConnInfo(Builder b) {
        host = b.host;
        port = b.port;
        virtualHost = b.virtualHost;
        username = b.username;
        password = b.password;
    }


    // 构造器
    public static class Builder {
        private String host;
        private int port;
        private String virtualHost;
        private String username;
        private String password;

        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setVirtualHost(String virtualHost) {
            this.virtualHost = virtualHost;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public ConnInfo build() {
            return new ConnInfo(this);
        }
    }
}

