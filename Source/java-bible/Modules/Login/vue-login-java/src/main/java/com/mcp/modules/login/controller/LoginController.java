package com.mcp.modules.login.controller;

import com.mcp.modules.login.api.CommonResult;
import com.mcp.modules.login.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Eli Shaw
 * @Date: 2019-11-14 11:33:26
 * @Description：
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456"))
            return CommonResult.success("admin");
        else
            return CommonResult.validateFailed();
    }
}
