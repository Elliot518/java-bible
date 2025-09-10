package com.mcp.lab.mq.rabbit.pubsub;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 5:21 PM
 * @modified by:
 */
public class SubscribeReceive1 {
    private static final String EXCHANGE_NAME = "publish_logs";

    public static void main(String[] argv) throws Exception {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // 订阅消息的回调函数
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [Subscriber 1] Received '" + message + "'");
        };

        // 消费者，有消息时触发订阅回调函数
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
