package com.mcp.demo.fastjson;

import com.alibaba.fastjson.JSON;
import com.mcp.demo.fastjson.model.MyData;

/**
 * @author: Elliot
 * @description:
 * @date: Created in 09:53 2024/6/25
 * @modified by:
 */
public class AppMain {
  public static void main(String[] args) {
    String jsonString = "{\"code\":\"200\",\"describe\":\"正常返回\",\"result\":{\"code\":\"adfadfafa\",\"taxNum\":\"123456\"}}";

    // Deserialize the JSON string to an instance of MyData
    MyData myData = JSON.parseObject(jsonString, MyData.class);

    // Access the deserialized data
    System.out.println("Code: " + myData.getCode());
    System.out.println("Describe: " + myData.getDescribe());
    System.out.println("Result Code: " + myData.getResult().getCode());
    System.out.println("TaxNum: " + myData.getResult().getTaxNum());
  }
}
