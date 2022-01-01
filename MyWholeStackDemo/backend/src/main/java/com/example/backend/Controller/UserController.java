package com.example.backend.Controller;

import com.example.backend.Entity.User;
import com.example.backend.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
@Api("用户模块")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    @ApiOperation("返回一个用户信息")
    public Object findUser()
    {
       // return "hello";
        return userService.findUser();
    }

    @ApiOperation("测试")
    @GetMapping("/test")
    public Object test()
    {
        return "hello";
    }
}
