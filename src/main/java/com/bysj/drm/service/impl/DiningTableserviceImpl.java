package com.bysj.drm.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bysj.drm.dao.DiningTableDao;
import com.bysj.drm.entity.DiningTable;
import com.bysj.drm.service.DiningTableservice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiningTableserviceImpl implements DiningTableservice {
    @Autowired
    private DiningTableDao diningTableDao;

    @Override
    @Transactional(readOnly = true)
    public List<DiningTable> getdiningTableByPage() {
        return diningTableDao.getdiningTableByPage();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int UpdateDiningTable(DiningTable dt) {
        return diningTableDao.UpdateDiningTable(dt);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int delDiningTable(Integer id) {
        return diningTableDao.delDiningTable(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int addDiningTable(DiningTable dt) {
        return diningTableDao.addDiningTable(dt);
    }

    @Override
    @Transactional(readOnly = true)
    public DiningTable getOneTable(Integer id) {
        return diningTableDao.getOneTable(id);
    }

    @Override
    @Transactional(readOnly = true)
    public int flagTableNum(String tableNum) {
        return diningTableDao.flagTableNum(tableNum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiningTable> getAlldiningTable(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return diningTableDao.getAlldiningTable();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int updateTableIsNo(Integer tabId) {
        return diningTableDao.updateTableIsNo(tabId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int updateTableIsOff(Integer tabId) {
        return diningTableDao.updateTableIsOff(tabId);
    }

    @Override
    @Transactional(readOnly = true)
    public DiningTable getOneTableBytabNum(String tabNum) {
        return diningTableDao.getOneTableBytabNum(tabNum);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiningTable> getdiningTable() {
        return diningTableDao.getdiningTable();
    }

}
