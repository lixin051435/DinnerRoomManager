package com.bysj.drm.dao;

import com.bysj.drm.dto.MenuCond;
import com.bysj.drm.entity.Menu;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface MenuDao {
    // 查询菜谱所有
    List<Menu> menuList(MenuCond cond);

    //添加菜谱
    @Insert("insert into menu (`type_id`,`m_name`,`m_price`,`image_path`,`remark`) values (#{typeId},#{mName},#{mPrice},#{imagePath},#{remark})")
    int AddMenu(Menu menu);

    //删除
    int delMenu(Integer id);

    //根据菜谱类型id获取菜谱集合
    List<Menu> getMenuByTypeId(Integer id);

    //根据id获取对象
    @Select("select *from menu where id=#{id} ")
    Menu getMenuByid(Integer id);

    //修改
    //修改
    @Update("update menu set type_id=#{typeId},m_name=#{mName},m_price=#{mPrice},image_path=#{imagePath},remark=#{remark} where id = #{id} ")
    int updateMenu(Menu menu);

    @Select("select *from menu")
    List<Menu> getAllMenu();

}
