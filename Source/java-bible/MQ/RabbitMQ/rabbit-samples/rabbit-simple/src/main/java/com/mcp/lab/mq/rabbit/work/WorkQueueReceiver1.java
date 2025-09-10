package com.mcp.lab.mq.rabbit.work;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 4:32 PM
 * @modified by:
 */
public class WorkQueueReceiver1 {
    private final static String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [Work Consumer 1] Received '" +
                    delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });

    }
}
