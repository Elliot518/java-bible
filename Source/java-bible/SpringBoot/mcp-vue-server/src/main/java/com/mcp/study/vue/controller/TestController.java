package com.mcp.study.vue.controller;

import com.mcp.study.vue.api.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午5:12 2022/4/7
 * @modified by:
 */
@Slf4j
@Api(tags = "测试[Hello]")
@RestController
@RequestMapping("/test")
@ResponseResult
public class TestController {
    @ApiOperation(value = "Test Boolean Response")
    @ResponseBody
    @GetMapping(value = "/bool")
    public Boolean testBool() {
        log.info("Test Boolean Response...");

        return true;
    }
}





