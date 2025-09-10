package com.mcp.lab.mq.rabbit.work;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 4:24 PM
 * @modified by:
 */
public class WorkQueueSender {
    private final static String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 100; i++) {
            String message = "work mode message" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[Producer] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }

        channel.close();
        connection.close();
    }
}
