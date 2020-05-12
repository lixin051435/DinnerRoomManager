package com.bysj.drm.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bysj.drm.dao.UsersDao;
import com.bysj.drm.dto.UserCond;
import com.bysj.drm.entity.Users;
import com.bysj.drm.service.Usersservice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsersserviceImpl implements Usersservice {
    @Autowired
    private UsersDao usersDao;


    @Override
    @Transactional(readOnly = true)
    public List<Users> getAllUsers(Integer page, Integer limit, UserCond cond) {
        PageHelper.startPage(page, limit);
        return usersDao.getAllUsers(cond);
    }

    @Override
    @Transactional(readOnly = true)
    public Users LoginUser(String loginName) {
        return usersDao.LoginUser(loginName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int delUser(Integer id) {
        return usersDao.delUser(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int UpdateUser(Users user) {
        return usersDao.UpdateUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int addUser(Users user) {
        return usersDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Users getOneuser(Integer id) {
        return usersDao.getOneuser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public int flagLoginName(String loginName) {
        return usersDao.flagLoginName(loginName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int UpUserPwd(Integer uid, String pwd) {
        return usersDao.UpUserPwd(uid, pwd);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int UpdateUserOnline(String loginName, Integer onlineNo) {
        return usersDao.UpdateUserOnline(loginName, onlineNo);
    }
}
