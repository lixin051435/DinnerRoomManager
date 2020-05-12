package com.bysj.drm.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bysj.drm.dao.MemberTypeDao;
import com.bysj.drm.entity.MemberType;
import com.bysj.drm.service.MemberTypeservice;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberTypeserviceImpl implements MemberTypeservice {
	
	@Autowired
	private MemberTypeDao memberTypeDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<MemberType> getAllMemberType() {
		return memberTypeDao.getAllMemberType();
	}
	@Override
	@Transactional(readOnly = true)
	public MemberType getOneMemberType(Integer id) {
		return memberTypeDao.getOneMemberType(id);
	}
	@Override
	@Transactional(readOnly = true)
	public List<MemberType> getAllMemberTypeByPage(Page page) {
		return memberTypeDao.getAllMemberTypeByPage(page);
	}
	@Override
	@Transactional(readOnly = true)
	public int flagMemberType(String typename) {
		return memberTypeDao.flagMemberType(typename);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int addMemberType(MemberType mt) {
		return memberTypeDao.addMemberType(mt);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delMemberType(Integer id) {
		return memberTypeDao.delMemberType(id);
	}


}
