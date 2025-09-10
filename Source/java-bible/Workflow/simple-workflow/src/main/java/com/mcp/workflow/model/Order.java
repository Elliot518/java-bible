package com.mcp.workflow.model;

import com.mcp.workflow.OrderType;
import com.mcp.workflow.PayType;
import lombok.Data;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 11:22 2025/8/28
 * @modified by:
 */
@Data
public class Order {
  private String orderId;

  private String productName;

  private Double amount;

  private String typeDesc;

  private OrderType type;

  private PayType payType;

  private User user;

  private Double discount;

  private String productId;

  private Integer quantity;
}

