package com.itzhy.controller;

import com.itzhy.pojo.Result;
import com.itzhy.pojo.Users;
import com.itzhy.service.LoginService;
import com.itzhy.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;
    //录操作，带jwt令牌
@PostMapping("/login")
    public Result login( @RequestBody Users users )
    {
        Users u1 = loginService.login(users.getUsername(),users.getPassword());
        //登录成功生成下发令牌
        if(u1!=null)
        {
            Map<String,Object> claims=new HashMap<>();
            claims.put("userId",u1.getUserId());
            claims.put("email",u1.getEmail());
            claims.put("username",u1.getUsername());
            claims.put("permissions",u1.getPermissions());
            String jwt = JwtUtils.generateJwt(claims);  //包含当前登录员工信息

            log.info(jwt);
            return Result.success(jwt);
        }
        return Result.error("账号或密码错误请重新输入");
    }

    //注册
@PostMapping("/register")
public Result register(@RequestBody Users users)
{//根据传来的username查询是否重复
    Users u1=loginService.getByusername(users.getUsername());
    //如果不是空的就注册空的返回错误
    if(u1!=null) {
        return Result.error("username已经存在请重新注册");
    }
    else
    {
        //创建新的数据
        loginService.register(users);
        return Result.success();
    }
}
//简单的登录没有jwt令牌的
    @PostMapping("/login1")
    public Result login1( @RequestBody Users users )
    {
        Users u1=loginService.login(users.getUsername(),users.getPassword());
        //登录成功生成下发令牌
        if(u1!=null)
        {

            return Result.success(u1);
        }
        return Result.error("账号或密码错误请重新输入");
    }
}
