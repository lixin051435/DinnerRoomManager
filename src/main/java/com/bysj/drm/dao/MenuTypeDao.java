package com.bysj.drm.dao;

import com.bysj.drm.entity.MenuType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface MenuTypeDao {
    //获取全部数据
    @Select("select *from menu_type")
    List<MenuType> getAllMenuType();

    //根据id获取对象
    MenuType getOne(Integer id);

    //分页获取数据
    @Select("select *from menu_type")
    List<MenuType> getAllMenuTypeBypage();

    //添加菜肴类型
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into menu_type(`type_name`)values (#{typeName} )")
    int addMenuType(MenuType menuType);

    //根据菜肴类型名称判断数据表中是否存在
    int getOneByname(String name);

    //删除
    @Delete("delete from menu_type where id=#{id} ")
    int delMenuType(Integer id);
}
