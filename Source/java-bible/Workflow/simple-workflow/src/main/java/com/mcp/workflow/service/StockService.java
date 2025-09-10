package com.mcp.workflow.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 13:19 2025/8/28
 * @modified by:
 */
/**
 * 库存服务类，负责处理库存相关操作
 */
public class StockService {
  // 模拟库存存储，key为产品ID，value为库存数量
  private Map<String, Integer> stockRepository = new HashMap<>();

  /**
   * 构造方法，初始化一些示例库存
   */
  public StockService() {
    // 初始化一些测试数据
    stockRepository.put("PROD001", 100);
    stockRepository.put("PROD002", 50);
    stockRepository.put("PROD003", 200);
  }

  /**
   * 扣减库存
   * @param productId 产品ID
   * @param quantity 要扣减的数量
   * @return 扣减成功返回true，否则返回false
   */
  public boolean deductStock(String productId, int quantity) {
    // 验证参数有效性
    if (productId == null || productId.isEmpty()) {
      System.out.println("Product ID cannot be empty");
      return false;
    }

    if (quantity <= 0) {
      System.out.println("The deduction quantity must be greater than 0");
      return false;
    }

    // 检查库存是否存在
    Integer currentStock = stockRepository.get(productId);
    if (currentStock == null) {
      System.out.println("Product does not exist:" + productId);
      return false;
    }

    // 检查库存是否充足
    if (currentStock < quantity) {
      System.out.println("Product " + productId + " Out of stock, current stock: " + currentStock + ",need: " + quantity);
      return false;
    }

    // 执行库存扣减
    stockRepository.put(productId, currentStock - quantity);
    System.out.println("Product " + productId + " Inventory deduction successful, deduction quantity: " + quantity +
            ", remaining stock: " + (currentStock - quantity));
    return true;
  }

  /**
   * 查询当前库存
   * @param productId 产品ID
   * @return 库存数量，若产品不存在返回0
   */
  public int getStock(String productId) {
    return stockRepository.getOrDefault(productId, 0);
  }

  /**
   * 增加库存
   * @param productId 产品ID
   * @param quantity 要增加的数量
   */
  public void addStock(String productId, int quantity) {
    if (quantity <= 0) {
      System.out.println("增加数量必须大于0");
      return;
    }

    int currentStock = stockRepository.getOrDefault(productId, 0);
    stockRepository.put(productId, currentStock + quantity);
    System.out.println("产品 " + productId + " 库存增加成功，增加数量: " + quantity +
            "，当前库存: " + (currentStock + quantity));
  }
}
