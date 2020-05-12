package com.bysj.drm.service;

import com.bysj.drm.entity.DinnerNotice;

import java.util.List;


public interface DinnerNoticeservice {
	// 根据id查询所有小票信息
	List<DinnerNotice> getAllDinnerNoticeByID(Integer id);

	// 删除订单编号下的小票
	int delNotice(Integer oid);

	// 添加小票
	int addNotice(DinnerNotice notice);
}
