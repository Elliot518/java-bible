package com.mcp.lab.mq.rabbit.work.round;

import com.mcp.lab.mq.rabbit.work.ConsumerGenerator;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description: round robin 轮询分发 - 消费者1
 * @date: Created in 2021年04月15日 10:48 AM
 * @modified by:
 */
public class RoundRecv1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConsumerGenerator gen = new ConsumerGenerator();
        gen.roundGenerate(RoundSend.QUEUE_NAME, "1", 2000);
    }
}

