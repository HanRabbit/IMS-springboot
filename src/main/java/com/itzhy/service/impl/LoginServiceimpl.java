package com.itzhy.service.impl;

import com.itzhy.mapper.LoginMapper;
import com.itzhy.pojo.Users;
import com.itzhy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Users login(String username, String password) {
        return loginMapper.login(username, password);
    }
//根据username查询
    @Override
    public Users getByusername(String username) {
        return loginMapper.getByusername(username);
    }

    @Override
    public void register(Users users) {
        loginMapper.register( users);
    }
}
