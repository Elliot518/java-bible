package com.mcp.lab.mq.rabbit.route;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 8:27 PM
 * @modified by:
 */
public class SimpleRouteSender {
    private final static String EXCHANGE_NAME = "exchange_direct";
    private final static String EXCHANGE_TYPE = "direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        // 交换机声明
        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        // 只有routingKey相同的才会消费
        String message = "routing mode message";
        channel.basicPublish(EXCHANGE_NAME, "key2", null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}

