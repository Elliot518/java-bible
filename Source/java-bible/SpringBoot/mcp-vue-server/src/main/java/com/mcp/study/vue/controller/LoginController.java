package com.mcp.study.vue.controller;

import com.mcp.study.vue.model.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: KG
 * @description:
 * @date: Created in 16:48 2022/6/1
 * @modified by:
 */
@RestController
public class LoginController {
    @RequestMapping("/login")
    public RespBean login() {
        return RespBean.error("登录失败，请重新登录！");
    }
}
