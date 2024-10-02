package com.itzhy.mapper;

import com.itzhy.pojo.Items;
import com.itzhy.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//员工的mapper部分
@Mapper
public interface EmpMapper {
    void updateUsers(Users users);

    @Select("select * from users")
    List<Users> getUsers();

    void delete(List<Integer> ids);

    @Update("update users set username=#{users.username},password=#{users.password},email=#{users.email},permissions=#{users.permissions} where user_id=#{userId}")
    void updateUsers1(Integer userId, Users users);

    @Select("select * from users where user_id=#{userId}")
    Users getbyId(Integer userId);
}
