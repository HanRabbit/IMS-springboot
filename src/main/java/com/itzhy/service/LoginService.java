package com.itzhy.service;

import com.itzhy.pojo.Users;

public interface LoginService {


     Users login(String username, String password);

    Users getByusername(String username);

    void register(Users users);
}
