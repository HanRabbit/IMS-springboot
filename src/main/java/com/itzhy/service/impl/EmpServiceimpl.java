package com.itzhy.service.impl;

import com.itzhy.mapper.EmpMapper;
import com.itzhy.pojo.Items;
import com.itzhy.pojo.Users;
import com.itzhy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceimpl implements EmpService {
    @Autowired
    EmpMapper empMapper;
    @Override
    public void updateUsers(Users users) {
        empMapper.updateUsers(users);
    }

    @Override
    public List<Users> getUsers() {

        return  empMapper.getUsers();
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public Users updateUsers(Integer userId, Users users) {
        empMapper.updateUsers1(userId,users);
        return empMapper.getbyId(userId);
    }
}
