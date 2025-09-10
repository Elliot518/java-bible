package com.mcp.workflow;

import com.mcp.workflow.model.Order;

/**
 * @author: Elliot
 * @description: Order process node interface
 * @date: Created in 11:21 2025/8/28
 * @modified by:
 */
public interface OrderProcessNode {
  // Process the order process and return whether
  // to continue executing the next node
  boolean process(Order order);
}

