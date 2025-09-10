package com.mcp.workflow;

import com.mcp.workflow.model.Order;
import com.mcp.workflow.service.StockService;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 12:00 2025/8/28
 * @modified by:
 */
// Inventory Deduction Node
public class StockDeductNode implements OrderProcessNode {
  private StockService stockService = new StockService(); // Simulated inventory service

  @Override
  public boolean process(Order order) {
    System.out.println("Step 5: Deduct order inventory");
    boolean deductSuccess = stockService.deductStock(order.getProductId(), order.getQuantity());
    if (deductSuccess) {
      System.out.println("Inventory deduction successful");
      return true;
    } else {
      System.out.println("Insufficient inventory, terminate the process");
      return false;
    }
  }
}
