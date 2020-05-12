package com.bysj.drm.dao;

import com.bysj.drm.entity.DiningTable;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/20 11:42
 */
public interface DiningTableDao {

    // 分页查询所有餐桌
    @Select("select *from dining_table")
    List<DiningTable> getdiningTableByPage();

    // 修改
    @Update("UPDATE `dinner`.`dining_table` SET `table_num` =#{tableNum} , `table_pernum` = #{tablePernum}  WHERE `id` = #{id} ;")
    int UpdateDiningTable(DiningTable dt);

    // 删除
    @Delete("delete from dining_table where id=#{id} ")
    int delDiningTable(Integer id);

    // 添加
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("INSERT INTO `dinner`.`dining_table`(`table_num`, `table_pernum`, `isno`) VALUES ( #{tableNum} , #{tablePernum} , #{isno} );")
    int addDiningTable(DiningTable dt);

    // 查询所有餐桌
    @Select("select *from dining_table where isno=0")
    List<DiningTable> getdiningTable();

    // 根据id获取餐桌对象
    @Select("select *from dining_table where id=#{id} ")
    DiningTable getOneTable(Integer id);

    // 根据餐桌号获取餐桌对象
    @Select("select *from dining_table where table_num=#{tabNum} ")
    DiningTable getOneTableBytabNum(String tabNum);

    // 判断餐桌编号是否存在
    @Select("select table_num from dining_table where table_num=#{tableNum} ")
    int flagTableNum(String tableNum);

    // 查询所有餐桌
    @Select("select * from dining_table")
    List<DiningTable> getAlldiningTable();

    // 修改餐桌有人就坐
    @Update("update dining_table set isno=1 where id=#{tabId} ")
    int updateTableIsNo(Integer tabId);

    // 修改餐桌为空
    @Update("update dining_table set isno=0 where id=#{tabId} ")
    int updateTableIsOff(Integer tabId);

}
