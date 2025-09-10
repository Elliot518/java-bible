package com.mcp.workflow;

import com.mcp.workflow.model.Order;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:54 2025/8/28
 * @modified by:
 */
// Discount compute node
public class DiscountCalculateNode implements OrderProcessNode {
  @Override
  public boolean process(Order order) {
    System.out.println("Step 4: Calculate order discount");
    double discount = 1.0;
    // Old user discount
    if (order.getUser().getOldUser()) {
      discount -= 0.1; // 10% off for old users
      System.out.println("10% discount for old users");
    }
    // Discounts when a certain amount is met
    if (order.getAmount() >= 5000) {
      discount -= 0.05; // 5% off for purchases over 5,000
      System.out.println("5% off for purchases over 5,000");
    }
    // Prevent discounts from falling below 0.5
    order.setDiscount(Math.max(discount, 0.5));
    System.out.println("Final discount: " + order.getDiscount());
    return true;
  }
}

