package com.bysj.drm.service;


import com.bysj.drm.entity.DiningTable;
import com.github.pagehelper.Page;

import java.util.List;

public interface DiningTableservice {
    // 分页查询所有餐桌
    List<DiningTable> getdiningTableByPage();

    // 查询所有餐桌
    List<DiningTable> getdiningTable();

    // 修改
    int UpdateDiningTable(DiningTable dt);

    // 删除
    int delDiningTable(Integer id);

    // 添加
    int addDiningTable(DiningTable dt);

    // 根据id获取餐桌对象
    DiningTable getOneTable(Integer id);

    // 根据餐桌号获取餐桌对象
    DiningTable getOneTableBytabNum(String tabNum);

    // 判断餐桌编号是否存在
    int flagTableNum(String tableNum);

    // 查询所有餐桌
    List<DiningTable> getAlldiningTable(Integer page,Integer limit);

    // 修改餐桌是否为空
    int updateTableIsNo(Integer tabId);

    // 修改餐桌为空
    int updateTableIsOff(Integer tabId);
}
