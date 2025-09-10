package com.mcp.lab.mq.rabbit.simple;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月25日 9:38 PM
 * @modified by:
 */
public class SimpleSender {
    private final static String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        // 声明队列
        // queue：队列名
        // durable：是否持久化
        // exclusive：是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景
        // autoDelete：是否自动删除  消费完删除
        // arguments：其他属性
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        String message = "simplest mode message";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("[Producer]Sent '" + message + "'");

        //最后关闭通关和连接
        channel.close();
        connection.close();

    }
}
