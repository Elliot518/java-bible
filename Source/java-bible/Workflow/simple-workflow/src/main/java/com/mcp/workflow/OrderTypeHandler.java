package com.mcp.workflow;

import com.mcp.workflow.model.Order;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:35 2025/8/28
 * @modified by:
 */
// Order Type Processor Interface (Strategy Interface)
public interface OrderTypeHandler {
  void handle(Order order);
}
