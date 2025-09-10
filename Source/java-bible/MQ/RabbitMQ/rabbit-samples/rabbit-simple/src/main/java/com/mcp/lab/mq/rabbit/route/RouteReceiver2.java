package com.mcp.lab.mq.rabbit.route;

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
 * @date: Created in 2021年04月26日 8:55 PM
 * @modified by:
 */
public class RouteReceiver2 {
    private final static String QUEUE_NAME = "queue_routing2";
    private final static String EXCHANGE_NAME = "exchange_direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 仅接收key2
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "key2");

        channel.basicQos(1);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [Route Consumer 2] Received '" +
                    delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}
