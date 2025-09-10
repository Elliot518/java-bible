package com.mcp.lab.mq.rabbit.pubsub;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.nio.charset.StandardCharsets;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 5:11 PM
 * @modified by:
 */
public class SimplePublishSender {
    private static final String EXCHANGE_NAME = "publish_logs";

    public static void main(String[] argv) throws Exception {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();


        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String message = "发布的主题信息";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println(" [Publisher] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
