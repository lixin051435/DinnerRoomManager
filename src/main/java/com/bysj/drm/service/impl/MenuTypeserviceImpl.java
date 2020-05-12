package com.bysj.drm.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bysj.drm.dao.MenuTypeDao;
import com.bysj.drm.entity.MenuType;
import com.bysj.drm.service.MenuTypeservice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuTypeserviceImpl implements MenuTypeservice {
    @Autowired
    private MenuTypeDao menuTypeDao;


    @Override
    @Transactional(readOnly = true)
    public List<MenuType> getAllMenuType() {
        return menuTypeDao.getAllMenuType();
    }

    @Override
    @Transactional(readOnly = true)
    public MenuType getOne(Integer id) {
        return menuTypeDao.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuType> getAllMenuTypeBypage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return menuTypeDao.getAllMenuTypeBypage();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int addMenuType(MenuType menuType) {
        return menuTypeDao.addMenuType(menuType);
    }

    @Override
    @Transactional(readOnly = true)
    public int getOneByname(String name) {
        return menuTypeDao.getOneByname(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int delMenuType(Integer id) {
        return menuTypeDao.delMenuType(id);
    }

}
