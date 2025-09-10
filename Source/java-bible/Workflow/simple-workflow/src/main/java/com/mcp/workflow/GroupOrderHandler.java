package com.mcp.workflow;

import com.mcp.workflow.model.Order;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:40 2025/8/28
 * @modified by:
 */
// Group purchase order processor (specific strategy)
public class GroupOrderHandler implements OrderTypeHandler {
  @Override
  public void handle(Order order) {
    System.out.println("Processing group purchase order logic");
    order.setTypeDesc("Group purchase orders must be made up of 3 people");
  }
}
