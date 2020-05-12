package com.bysj.drm.service.impl;

import com.bysj.drm.dao.DinnerOrderDao;
import com.bysj.drm.dto.DayInfo;
import com.bysj.drm.dto.DinnerOrderCond;
import com.bysj.drm.entity.DiningTable;
import com.bysj.drm.entity.DinnerOrder;
import com.bysj.drm.service.DiningTableservice;
import com.bysj.drm.service.DinnerOrderservice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class DinnerOrderserviceImpl implements DinnerOrderservice {


    @Autowired
    private DinnerOrderDao dinnerOrderDao;

    @Autowired
    private DiningTableservice diningTableservice;

    @Override
    public DayInfo getDayInfo(String day1, String day2) {
        return dinnerOrderDao.getDayInfo(day1,day2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DinnerOrder> getAllDinnerOrder(Integer page, Integer limit, DinnerOrderCond cond) {
        PageHelper.startPage(page, limit);
        return dinnerOrderDao.getAllDinnerOrder(cond);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int delOrderInfo(Integer id) {
        return dinnerOrderDao.delOrderInfo(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DinnerOrder> getAllDinnerOrderByhouchu(Page page) {
        return dinnerOrderDao.getAllDinnerOrderByhouchu(page);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int UpdateisFull(Integer id) {
        return dinnerOrderDao.UpdateisFull(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int addOrder(DinnerOrder order) {
        int addOrder = dinnerOrderDao.addOrder(order);
        if (addOrder > 1) {
            //更新可用餐桌
            DiningTable oneTableBytabNum = diningTableservice.getOneTableBytabNum(order.getTableId());
            oneTableBytabNum.setIsno(1);
            diningTableservice.UpdateDiningTable(oneTableBytabNum);
        }
        return addOrder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DinnerOrder> getAllDinnerOrderByQT(Integer page, Integer limit,
                                                   DinnerOrderCond cond) {
        PageHelper.startPage(page, limit);
        return dinnerOrderDao.getAllDinnerOrderByQT(cond);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int updateOrder(Integer oid, Double price) {
        return dinnerOrderDao.updateOrder(oid, price);
    }

    @Override
    @Transactional(readOnly = true)
    public String homeInfo() {
        return dinnerOrderDao.homeInfo();
    }

    @Override
    public DinnerOrder getAllnoticeByid(Integer id) {
        return dinnerOrderDao.getAllnoticeByid(id);
    }

    @Override
    public List<DinnerOrder> getStatChart(String day1, String day2) {
        return dinnerOrderDao.getStatChart(day1, day2);
    }

    @Override
    public List<DinnerOrder> getThisDate() {

        return dinnerOrderDao.getThisDate();
    }

}
