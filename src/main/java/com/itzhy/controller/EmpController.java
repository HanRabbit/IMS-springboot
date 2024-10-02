package com.itzhy.controller;

import com.itzhy.pojo.Items;
import com.itzhy.pojo.Result;
import com.itzhy.pojo.Users;
import com.itzhy.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class EmpController {
    @Autowired
    //新建empService自动注入
   private EmpService empService;
    //更新员工数据
    @PutMapping("/users")
    public Result updateUsers(@RequestBody Users users)
    {
        empService.updateUsers(users);
        return Result.success();
    }
    //获取所有员工的名单
    @GetMapping("/users")
    public Result getUsers() {
        List<Users> users= empService.getUsers();
        return Result.success(users);
    }

    //多项删除
    @DeleteMapping("/users/{ids}")
    public Result delete(@PathVariable List<Integer> ids)
    {
        empService.delete(ids);
        return Result.success();
    }
    //物资修改操作
    @PutMapping("/users/{userId}")
    public Result updateUsers(@PathVariable Integer userId, @RequestBody Users users) {
        Users updatedUsers = empService.updateUsers(userId, users);
        if (updatedUsers != null) {
            return Result.success("修改成功");
        } else {
            return Result.success("修改失败");
        }
    }
}
