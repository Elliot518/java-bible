package com.mcp.test.components.rabbit.producer;

import com.mcp.components.rabbit.client.api.producer.ConsoleProducerClient;
import com.mcp.components.rabbit.client.api.producer.ProducerClient;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月15日 10:37 PM
 * @modified by:
 */
public class ProducerTest {
    public static void main(String[] args) {
        try (ProducerClient client = new ConsoleProducerClient("simple_queue")) {
            client.send("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
