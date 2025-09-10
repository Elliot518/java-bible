package com.mcp.study.vue.service;



import com.mcp.study.vue.model.Menu;
import com.mcp.study.vue.model.RespBean;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuBiUserId();

    // 查询访问每一个路径所所需要的角色
//    List<Menu> getAllMenuWithRole();

//    List<Role> getHrRolesById(Integer id);
//
//    RespBean getMenuAll();

}
