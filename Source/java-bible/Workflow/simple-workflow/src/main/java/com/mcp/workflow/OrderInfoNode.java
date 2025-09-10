package com.mcp.workflow;

import com.mcp.workflow.model.Order;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:31 2025/8/28
 * @modified by:
 */
// Get basic order information
public class OrderInfoNode implements OrderProcessNode {
  @Override
  public boolean process(Order order) {
    System.out.println("Step 1: Get basic order information");
    // Simulate getting order details from the database
    order.setProductName("iPhone 15");
    order.setAmount(5999.0);
    return true; // Continue to execute the next node
  }
}
