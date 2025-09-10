package com.mcp.workflow;

import com.mcp.workflow.model.Order;
import com.mcp.workflow.service.LogService;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 13:24 2025/8/28
 * @modified by:
 */
// logging node
public class OrderLogNode implements OrderProcessNode {
  private LogService logService = new LogService(); // Simulation log service

  @Override
  public boolean process(Order order) {
    System.out.println("Step 6: Record order log");
    logService.recordLog("Order " + order.getOrderId() + " Processing completed, final amount: " + order.getAmount() * order.getDiscount());
    return true;
  }
}
