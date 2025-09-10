package com.mcp.lab.mq.rabbit.common.util;

import com.mcp.lab.mq.rabbit.common.domain.ConnInfo;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {
    /**
     * 连接器(默认)
     *
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        ConnInfo connInfo = new ConnInfo.Builder()
                .setHost("192.168.1.20")
                .setPort(5672)
                .setVirtualHost("kg_host")
                .setUsername("kg")
                .setPassword("123456")
                .build();

        return getConnection(connInfo);
    }

    public static Connection getConnection(ConnInfo connInfo) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(connInfo.getHost());
        factory.setPort(connInfo.getPort());
        factory.setVirtualHost(connInfo.getVirtualHost());
        factory.setUsername(connInfo.getUsername());
        factory.setPassword(connInfo.getPassword());

        return factory.newConnection();
    }
}
