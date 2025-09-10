package com.mcp.lab.mq.rabbit.work.fair;

import com.mcp.lab.mq.rabbit.work.ConsumerGenerator;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年04月15日 8:09 PM
 * @modified by:
 */
public class FairRecv1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConsumerGenerator gen = new ConsumerGenerator();
        gen.fairGenerate(FairSend.QUEUE_NAME, "1", 2000);
    }
}

