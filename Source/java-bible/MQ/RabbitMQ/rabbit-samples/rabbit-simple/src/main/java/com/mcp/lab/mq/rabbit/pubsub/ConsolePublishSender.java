package com.mcp.lab.mq.rabbit.pubsub;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 5:11 PM
 * @modified by:
 */
public class ConsolePublishSender {
    private static final String QUIT = "Q";
    private static final String EXCHANGE_NAME = "publish_logs";

    public static void main(String[] argv) throws Exception {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 输入发送的消息
        Scanner input = new Scanner(System.in);
        String msg = "";
        while (true) {
            System.out.print("请输入发送的消息: ");
            msg = input.nextLine();

            if (QUIT.equals(msg.toUpperCase())) {
                break;
            }

            channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [Publisher] Sent '" + msg + "'");
        }

        channel.close();
        connection.close();
    }
}


