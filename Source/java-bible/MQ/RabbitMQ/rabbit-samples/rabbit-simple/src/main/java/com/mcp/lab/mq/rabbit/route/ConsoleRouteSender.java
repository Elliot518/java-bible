package com.mcp.lab.mq.rabbit.route;

import com.mcp.lab.mq.rabbit.common.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月26日 8:27 PM
 * @modified by:
 */
public class ConsoleRouteSender {
    private static final String QUIT = "Q";
    private final static String EXCHANGE_NAME = "exchange_direct";
    private final static String EXCHANGE_TYPE = "direct";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取一个连接
        Connection connection = ConnectionUtils.getConnection();

        // 从连接获取一个通道
        Channel channel = connection.createChannel();

        // 交换机声明
        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        // 输入发送的消息
        Scanner input = new Scanner(System.in);
        String msg = "";
        while (true) {
            System.out.print("请输入发送的消息: ");
            msg = input.nextLine();

            if (QUIT.equals(msg.toUpperCase())) {
                break;
            }

            // 只有routingKey相同的才会消费
            channel.basicPublish(EXCHANGE_NAME, "key2", null, msg.getBytes());
            //channel.basicPublish(EXCHANGE_NAME, "key", null, msg.getBytes());
            System.out.println("[Route Producer] Sent '" + msg + "'");
        }


        channel.close();
        connection.close();
    }
}







