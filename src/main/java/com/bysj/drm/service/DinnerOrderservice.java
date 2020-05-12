package com.bysj.drm.service;

import com.bysj.drm.common.CommonResults;
import com.bysj.drm.dto.ChartDto;
import com.bysj.drm.dto.DayInfo;
import com.bysj.drm.dto.DinnerOrderCond;
import com.bysj.drm.entity.DinnerOrder;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DinnerOrderservice {

    DayInfo getDayInfo(String day1, String day2);
    // 多条件分页查询数据
    List<DinnerOrder> getAllDinnerOrder(Integer page, Integer limit, DinnerOrderCond cond);

    // 删除
    int delOrderInfo(Integer id);

    // 后厨查询菜单详情
    List<DinnerOrder> getAllDinnerOrderByhouchu(Page page);

    // 后厨上菜已经齐全
    int UpdateisFull(Integer id);

    // 添加订单
    int addOrder(DinnerOrder order);

    // 前台结算订单页查询
    List<DinnerOrder> getAllDinnerOrderByQT(Integer page, Integer limit, DinnerOrderCond cond);

    // 订单结算
    int updateOrder(Integer oid, Double price);

    // 计算报表信息
    String homeInfo();

    DinnerOrder getAllnoticeByid(Integer id);

    List<DinnerOrder> getStatChart(String day1, String day2);

    List<DinnerOrder> getThisDate();

}
