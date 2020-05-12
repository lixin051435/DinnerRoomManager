package com.bysj.drm.dao;

import com.bysj.drm.dto.UserCond;
import com.bysj.drm.entity.Users;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UsersDao {
    //登陆
    @Select("select *from users where u_loginname=#{loginName} ")
    Users LoginUser(String loginName);

    //查询所有用户信息
    @Select("<script>" +
            "select *from users " +
            "<where>" +
            "</where> </script>")
    List<Users> getAllUsers(UserCond cond);

    //删除
    @Delete("delete from users where id=#{id}")
    int delUser(Integer id);

    //修改
    @Update("UPDATE dinner.users SET u_loginname =#{uLoginname} , " +
            "u_pwd = #{uPwd} , u_name = #{uName} , u_sex = #{uSex} , " +
            "u_phone =#{uPhone} , u_idcard = #{uIdcard} , u_address = #{uAddress} ," +
            " u_role = #{uRole}  WHERE id = #{id} ;")
    int UpdateUser(Users user);

    //添加
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("INSERT INTO dinner.users ( u_loginname, u_pwd, u_name, u_sex, u_phone, u_idcard, u_address, u_role) VALUES (#{uLoginname} ," +
            "#{uPwd} , #{uName} , #{uSex} , #{uPhone} , #{uIdcard} , #{uAddress} , #{uRole} );")
    int addUser(Users user);

    //根据id获取对象
    @Select("select *from users where id=#{id} ")
    Users getOneuser(Integer id);

    //判断登录名是否存在
    int flagLoginName(String loginName);

    //修改登录用户密码
    @Update("update users set u_pwd=#{pwd } where id=#{uid}")
    int UpUserPwd(@Param("uid") Integer uid, @Param("pwd") String pwd);

    //修改用户在线状态
    int UpdateUserOnline(String loginName, Integer onlineNo);
}
