package com.itzhy.service;

import com.itzhy.pojo.Items;
import com.itzhy.pojo.Users;

import java.util.List;

public interface EmpService {
    void updateUsers(Users users);

    List<Users> getUsers();

    void delete(List<Integer> ids);

    Users updateUsers(Integer userId, Users users);
}
