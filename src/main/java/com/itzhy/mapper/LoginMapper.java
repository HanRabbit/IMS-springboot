package com.itzhy.mapper;

import com.itzhy.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
//根据账号密码查询
@Mapper
public interface LoginMapper {
@Select("select * from users where username=#{username} and password=#{password} ")
  public   Users login(String username, String password);

//根据账号查询
  @Select("select * from users where username=#{username}")
    Users getByusername(String username);
//注册的操作
  @Insert("insert into users(username, password, email) values(#{username},#{password},#{email}) ")
public   void register(Users users);
}
