package com.mcp.study.vue.model;

/**
 * @author: KG
 * @description:
 * @date: Created in 19:53 2022/5/21
 * @modified by:
 */
public class RespBean {
    private Integer status;
    private String msg;
    private Object object;

    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean ok(String msg, Object o) {
        return new RespBean(200, msg, o);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean error(String msg, Object o) {
        return new RespBean(500, msg, o);
    }

    private RespBean() {

    }

    public RespBean(Integer status, String msg, Object object) {
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
