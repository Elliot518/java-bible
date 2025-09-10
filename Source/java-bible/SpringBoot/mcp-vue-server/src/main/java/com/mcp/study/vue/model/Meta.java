package com.mcp.study.vue.model;

/**
 * *  为了配合 前端 mata:{
 *  *      keepAlive:'',
 *  *      requireAuth:''
 *  *  }
 *  *  格式
 * @ ClassName Meta
 * @ Descriotion TODO
 * @ author  codeFarmer_z
 * @ 公众号：码农教程
 * @ Date 2022/3/20 22:24
 **/
public class Meta {
    private Boolean keepAlive;

    //是否登录后才能访问，menu 在前端写死时需要这个属性
    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
