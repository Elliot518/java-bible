package com.mcp.lab.mq.rabbit.simple;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class ConsoleSender {
    private static final String QUIT = "Q";
    public static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        // 创建队列声明
        // queue：队列名
        // durable：是否持久化
        // exclusive：是否排外  即只允许该channel访问该队列   一般等于true的话用于一个队列只能有一个消费者来消费的场景
        // autoDelete：是否自动删除  消费完删除
        // arguments：其他属性
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 输入发送的消息
        Scanner input = new Scanner(System.in);
        String msg = "";
        while (true) {
            System.out.print("请输入发送的消息: ");
            msg = input.nextLine();

            if (QUIT.equals(msg.toUpperCase())) {
                break;
            }

            // exchange，队列，参数，消息字节体
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("Producer发送的消息: " + msg);
        }

        // 清理工作
        channel.close();
        connection.close();
    }
}


