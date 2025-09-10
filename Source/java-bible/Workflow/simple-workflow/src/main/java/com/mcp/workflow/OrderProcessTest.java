package com.mcp.workflow;

import com.mcp.workflow.model.Order;
import com.mcp.workflow.model.User;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 14:23 2025/8/28
 * @modified by:
 */
public class OrderProcessTest {
  public static void main(String[] args) {
    // 1. Create an order object
    Order order = new Order();
    order.setOrderId("ORDER_20250826_001");
    order.setType(OrderType.NORMAL); // Ordinary order
    order.setPayType(PayType.WECHAT); // WeChat Pay
    order.setProductId("PROD001");
    order.setQuantity(1);
    User user = new User();
    user.setOldUser(true); // old user
    order.setUser(user);

    // 2. Build a process chain and add nodes in sequence
    OrderProcessChain chain = new OrderProcessChain();
    chain.addNode(new OrderInfoNode());
    chain.addNode(new OrderTypeNode());
    chain.addNode(new PayCheckNode());
    chain.addNode(new DiscountCalculateNode());
    chain.addNode(new StockDeductNode());
    chain.addNode(new OrderLogNode());

    // 3. Execution Process
    System.out.println("Start processing orders:" + order.getOrderId());
    chain.execute(order);
  }
}
