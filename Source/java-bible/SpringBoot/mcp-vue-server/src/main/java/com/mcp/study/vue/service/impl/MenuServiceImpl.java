package com.mcp.study.vue.service.impl;

import com.mcp.study.vue.mapper.MenuMapper;
import com.mcp.study.vue.model.Hr;
import com.mcp.study.vue.model.Menu;
import com.mcp.study.vue.model.RespBean;
import com.mcp.study.vue.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ ClassName MenuServiceImpl
 * @ Descriotion TODO
 * @ author  codeFarmer_z
 * @ 公众号：码农教程
 * @ Date 2022/3/20 22:37
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getMenuBiUserId() {
        //通过登录后内存中存储的id查找
        Integer id = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Menu> menusList = menuMapper.getMenusByHrId(id);
        return menusList;
    }

//    public List<Menu> getAllMenuWithRole() {
//        return menuMapper.getAllMenuWithRole();
//    }

//    @Override
//    public List<Role> getHrRolesById(Integer id) {
//        return menuMapper.getHrRolesById(id);
//    }
//
//    @Override
//    public RespBean getMenuAll() {
//        List<Menu> menuAll = menuMapper.getMenuAll();
//        if (menuAll != null) {
//            return RespBean.ok("", menuAll);
//        }
//        return RespBean.error("查询失败");
//    }
}
