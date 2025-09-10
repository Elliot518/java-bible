package com.mcp.lab.mq.rabbit.work.round;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description: round robin 轮询分发 - 发送者
 * @date: Created in 2021年04月15日 10:41 AM
 * @modified by:
 */
public class RoundSend {
    public static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        // 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 获取 channel
        Channel channel = connection.createChannel();
        // 声明队列
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i = 0; i < 50; i++) {
            String msg = "hello-" + i;
            System.out.println("WQ send " + msg);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            Thread.sleep(i * 20);
        }
        channel.close();
        connection.close();
    }
}
