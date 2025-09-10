package com.mcp.middleware.demo.whitelist.annotation;

import java.lang.annotation.*;

/**
 * Create by KG
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoWhiteList {

    String key() default "";

    String returnJson() default "";

}
