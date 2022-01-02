package com.example.backend.Controller;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.example.backend.Entity.User;
import com.example.backend.Service.UserService;
import com.example.backend.Util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api("用户模块")
@Slf4j
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

    @ApiOperation("测试")
    @PostMapping("/postTest")
    public Object postTest()
    {
        return "hello";
    }

    //Sa-token 测试

    @ApiOperation("用户登录")
    @PostMapping("/doLogin")
    public SaResult doLogin(String userId, String passWord)
    {
            StpUtil.logout();
            StpUtil.login(userId);
            return SaResult.ok("登录成功");
    }


    @ApiOperation("返回当前账号的token")
    @GetMapping("/getToken")
    public SaResult getToken()
    {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    @GetMapping("/getSaTokenConfig")
    @ApiOperation("Sa-Token配置")
    public SaTokenConfig getSaTokenConfig()
    {
        log.info("Sa-Token配置：{}", SaManager.getConfig());
        return SaManager.getConfig();
    }

    @GetMapping("/getTokenValueByLoginId")
    @ApiOperation("获取账号id为xxx的token令牌值")
    public String getTokenValueByLoginId(String userId)
    {
        return StpUtil.getTokenValueByLoginId(userId);
    }

    @GetMapping("/isLogin")
    @ApiOperation("查询登录状态")
    public AjaxJson isLogin() {

        return AjaxJson.get(200,"当前会话是否登录：" + StpUtil.isLogin());
    }

    @GetMapping("/logout")
    @ApiOperation("退出登录")
    public AjaxJson logout() {
        StpUtil.logout(StpUtil.getLoginId());
        return AjaxJson.get(200,"退出登陆");
    }

}
