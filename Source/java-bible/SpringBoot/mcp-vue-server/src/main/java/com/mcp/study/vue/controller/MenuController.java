package com.mcp.study.vue.controller;

import com.mcp.study.vue.model.Menu;
import com.mcp.study.vue.model.RespBean;
import com.mcp.study.vue.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ ClassName MenuController
 * @ Descriotion TODO
 * @ author  codeFarmer_z
 * @ 公众号：码农教程
 * @ Date 2022/3/20 22:35
 **/
@RestController
@RequestMapping("/sys/")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("menu")
    public RespBean getMenuBiUserId() {
        List<Menu> list = menuService.getMenuBiUserId();
        return RespBean.ok("查询成功", list);
    }
}
