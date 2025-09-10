package com.mcp.lab.mq.rabbit.topic;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 9:31 PM
 * @modified by:
 */
public class SimpleTopicSender {
    private final static String EXCHANGE_NAME = "exchange_topic";
    private final static String EXCHANGE_TYPE = "topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        String message = "topics model message with key.1";
        channel.basicPublish(EXCHANGE_NAME, "key.1", null, message.getBytes());
        System.out.println("[Producer] Sent '" + message + "'");

        String message2 = "topics model message with key.1.2";
        channel.basicPublish(EXCHANGE_NAME, "key.1.2", null, message2.getBytes());
        System.out.println("[Producer] Sent '" + message2 + "'");

        channel.close();
        connection.close();
    }
}
