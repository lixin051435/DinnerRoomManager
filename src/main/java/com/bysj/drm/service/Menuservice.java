package com.bysj.drm.service;

import com.bysj.drm.dto.MenuCond;
import com.bysj.drm.entity.Menu;
import com.github.pagehelper.Page;

import java.util.List;


public interface Menuservice {
    // 查询菜谱所有
    List<Menu> menuList(Integer page, Integer limit, MenuCond cond);

    // 添加菜谱
    int AddMenu(Menu menu);

    // 删除
    int delMenu(Integer id);

    // 根据菜谱类型id获取菜谱对象
    List<Menu> getMenuByTypeId(Integer id);

    // 根据id获取对象
    Menu getMenuByid(Integer id);

    // 修改
    int updateMenu(Menu menu);

    List<Menu> getAllMenu();

}
