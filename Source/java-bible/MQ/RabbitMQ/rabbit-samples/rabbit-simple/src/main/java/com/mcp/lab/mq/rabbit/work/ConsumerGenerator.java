package com.mcp.lab.mq.rabbit.work;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月15日 10:58 AM
 * @modified by:
 */
public class ConsumerGenerator {
    /*
     * generate consumer by round robbin mode
     * @author KG
     * @date 2021/4/15 11:39 AM
     * @param name
     * @param waitMillis
     */
    public void roundGenerate(String queue, String name, long waitMillis) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 获取通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(queue, false, false, false, null);
        //定义消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 事件触发机制
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body, StandardCharsets.UTF_8);
                System.out.println(String.format("【%s】：", name) + s);
                try {
                    Thread.sleep(waitMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.printf("【%s】 done", name);
                }
            }
        };
        boolean autoAck = true;
        channel.basicConsume(queue, autoAck, consumer);
    }

    /*
     * generate consumer by fair dispatch mode
     * @author KG
     * @date 2021/4/15 8:19 PM
     * @param queue
     * @param name
     * @param waitMillis
     */
    public void fairGenerate(String queue, String name, long waitMillis) throws IOException, TimeoutException {
        // 获取连接
        Connection connection = ConnectionUtils.getConnection();
        // 获取通道
        final Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(queue, false, false, false, null);
        // 保证一次只分发一个
        channel.basicQos(1);
        //定义消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            // 事件触发机制
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body, StandardCharsets.UTF_8);
                System.out.println(String.format("【%s】：", name) + s);
                try {
                    Thread.sleep(waitMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.printf("【%s】 done", name);
                    // 手动回执
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        // 自动应答
        boolean autoAck = false;
        channel.basicConsume(queue, autoAck, consumer);
    }
}