package com.bysj.drm.service;

import com.bysj.drm.dto.UserCond;
import com.bysj.drm.entity.Users;
import com.github.pagehelper.Page;

import java.util.List;

public interface Usersservice {
    // 登陆
    Users LoginUser(String loginName);

    // 分页查询所有用户信息
    List<Users> getAllUsers(Integer page, Integer limit, UserCond cond);

    // 删除
    int delUser(Integer id);

    // 修改
    int UpdateUser(Users user);

    // 添加
    int addUser(Users user);

    // 根据id获取对象
    Users getOneuser(Integer id);

    // 判断登录名是否存在
    int flagLoginName(String loginName);

    // 修改登录用户密码
    int UpUserPwd(Integer uid, String pwd);

    // 修改用户在线状态
    int UpdateUserOnline(String loginName, Integer onlineNo);

}
