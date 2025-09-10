package com.mcp.study.vue.mapper;




import com.mcp.study.vue.model.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> getMenusByHrId(Integer hrId);

//    List<Menu> getAllMenuWithRole();
//
//    List<Role> getHrRolesById(Integer id);
//
//    List<Menu> getMenuAll();

}