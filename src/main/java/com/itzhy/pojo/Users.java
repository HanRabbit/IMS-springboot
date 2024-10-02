package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//用户的实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Integer userId;//用户的id
    private String username;//用户的账号
    private String password;//用户的密码
    private String email;//用户的邮箱
    private Integer permissions;//用户的权限
}
