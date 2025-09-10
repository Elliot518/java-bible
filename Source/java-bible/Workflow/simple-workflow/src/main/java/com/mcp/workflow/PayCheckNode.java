package com.mcp.workflow;

import com.mcp.workflow.model.Order;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:49 2025/8/28
 * @modified by:
 */
// Payment verification node
public class PayCheckNode implements OrderProcessNode {
  @Override
  public boolean process(Order order) {
    System.out.println("Step 3: Verify payment method");
    if (order.getPayType() == PayType.WECHAT || order.getPayType() == PayType.ALIPAY) {
      System.out.println("The payment method is legal: " + order.getPayType());
      return true;
    } else {
      System.out.println("Unsupported payment methods: " + order.getPayType() + ", Terminate process");
      return false;
    }
  }
}
