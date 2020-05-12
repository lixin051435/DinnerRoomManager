package com.bysj.drm.service;

import com.bysj.drm.entity.MenuType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.util.List;


public interface MenuTypeservice {
    // 获取全部数据
    List<MenuType> getAllMenuType();

    // 根据id获取对象
    MenuType getOne(Integer id);

    // 分页获取数据
    List<MenuType> getAllMenuTypeBypage(Integer page, Integer limit);

    // 添加菜肴类型
    int addMenuType(MenuType menuType);

    // 根据菜肴类型名称判断数据表中是否存在
    int getOneByname(String name);

    // 删除
    int delMenuType(Integer id);
}
