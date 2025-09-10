package com.mcp.test.components.rabbit.consumer;

import com.mcp.components.rabbit.client.api.consumer.ConsumerClient;
import com.mcp.components.rabbit.client.api.consumer.RoundConsumerClient;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月16日 11:12 AM
 * @modified by:
 */
public class ConsumerTest {
    public static void main(String[] args) {
        try {
            ConsumerClient client = new RoundConsumerClient("simple_queue");
            client.consume(2000);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
