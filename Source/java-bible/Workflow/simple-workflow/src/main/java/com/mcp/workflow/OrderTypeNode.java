package com.mcp.workflow;

import com.mcp.workflow.model.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:45 2025/8/28
 * @modified by:
 */
// Order type judgment node
public class OrderTypeNode implements OrderProcessNode {
  // Strategy factory, obtains the corresponding processor according to the order type
  private Map<OrderType, OrderTypeHandler> typeHandlerMap;
  // Constructor initializes the strategy factory
  public OrderTypeNode() {
    typeHandlerMap = new HashMap<>();
    typeHandlerMap.put(OrderType.NORMAL, new NormalOrderHandler());
    typeHandlerMap.put(OrderType.GROUP, new GroupOrderHandler());
  }
  @Override
  public boolean process(Order order) {
    System.out.println("Step 2: Determine the order type");
    // Get the processor according to the order type and execute the corresponding logic
    OrderTypeHandler handler = typeHandlerMap.get(order.getType());
    if (handler == null) {
      System.out.println("Unknown order type, terminate the process");
      return false; // Terminate process
    }
    handler.handle(order);
    return true; // Continue to execute the next node
  }
}
