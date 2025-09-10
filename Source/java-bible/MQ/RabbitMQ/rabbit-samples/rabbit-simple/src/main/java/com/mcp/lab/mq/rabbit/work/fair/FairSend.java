package com.mcp.lab.mq.rabbit.work.fair;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description: 公平分发 fair dipatch - 发送者
 * @date: Created in 2021年04月15日 11:26 AM
 * @modified by:
 */
public class FairSend {
    public static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 获取 channel
        Channel channel = connection.createChannel();
        // 声明队列
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 每个消费者发送确认消息之前，消息队列不发送下一个消息到消费者，一次只发送一个消息
        // 从而限制一次性发送给消费者到消息不得超过1个。
        int perFetchCount = 1;
        channel.basicQos(perFetchCount);

        for (int i = 0; i < 100; i++) {
            String msg = "hello-" + i;
            System.out.println("WQ send " + msg);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            Thread.sleep(i * 20);
        }
        channel.close();
        connection.close();
    }
}


