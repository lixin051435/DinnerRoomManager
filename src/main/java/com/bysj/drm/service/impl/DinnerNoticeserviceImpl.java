package com.bysj.drm.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bysj.drm.dao.DinnerNoticeDao;
import com.bysj.drm.entity.DinnerNotice;
import com.bysj.drm.service.DinnerNoticeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DinnerNoticeserviceImpl implements DinnerNoticeservice {

    @Autowired
    private DinnerNoticeDao dinnerNoticeDao;


    @Override
    @Transactional(readOnly = true)
    public List<DinnerNotice> getAllDinnerNoticeByID(Integer id) {
        return dinnerNoticeDao.getAllDinnerNoticeByID(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int delNotice(Integer oid) {
        return dinnerNoticeDao.delNotice(oid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    public int addNotice(DinnerNotice notice) {
        return dinnerNoticeDao.addNotice(notice);
    }

}
