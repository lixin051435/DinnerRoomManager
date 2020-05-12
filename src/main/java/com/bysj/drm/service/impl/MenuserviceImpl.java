package com.bysj.drm.service.impl;

import com.bysj.drm.dao.MenuDao;
import com.bysj.drm.dto.MenuCond;
import com.bysj.drm.entity.Menu;
import com.bysj.drm.service.Menuservice;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class MenuserviceImpl implements Menuservice {

    @Autowired
    private MenuDao menuDao;


    @Override
    @Transactional(readOnly = true)
    public List<Menu> menuList(Integer page, Integer limit, MenuCond cond) {
        System.out.println("cond.getM_name() = " + cond.getM_name());
        PageHelper.startPage(page, limit);
        return menuDao.menuList(cond);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int AddMenu(Menu menu) {
        return menuDao.AddMenu(menu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int delMenu(Integer id) {
        return menuDao.delMenu(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> getMenuByTypeId(Integer id) {
        return menuDao.getMenuByTypeId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Menu getMenuByid(Integer id) {
        return menuDao.getMenuByid(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int updateMenu(Menu menu) {
        return menuDao.updateMenu(menu);
    }

    @Override
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }


}
