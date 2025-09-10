package com.mcp.workflow;

import com.mcp.workflow.model.Order;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:39 2025/8/28
 * @modified by:
 */
// General order processor (specific strategy)
public class NormalOrderHandler implements OrderTypeHandler {
  @Override
  public void handle(Order order) {
    System.out.println("Processing normal order logic");
    order.setTypeDesc("Ordinary orders, support WeChat/Alipay payment");
  }
}