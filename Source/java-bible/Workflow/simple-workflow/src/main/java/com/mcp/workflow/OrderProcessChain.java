package com.mcp.workflow;

import com.mcp.workflow.model.Order;

import java.util.LinkedList;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 14:19 2025/8/28
 * @modified by:
 */
// Order Process Manager (Chain of Responsibility)
public class OrderProcessChain {
  // Use linked lists to store all nodes to ensure execution order
  private LinkedList<OrderProcessNode> nodeList = new LinkedList<>();

  // Add a node to the end of the chain
  public void addNode(OrderProcessNode node) {
    nodeList.add(node);
  }

  // Execution process: call the process method of each node in turn
  public void execute(Order order) {
    for (OrderProcessNode node : nodeList) {
      boolean continueNext = node.process(order);
      if (!continueNext) {
        System.out.println("process at node [" + node.getClass().getSimpleName() + "] terminated!");
        return;
      }
    }
    System.out.println("All process nodes have been executed!");
  }
}
