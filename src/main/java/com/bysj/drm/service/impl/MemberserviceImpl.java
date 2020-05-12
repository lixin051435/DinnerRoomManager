package com.bysj.drm.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bysj.drm.dao.MemberDao;
import com.bysj.drm.dto.MemberCond;
import com.bysj.drm.entity.Member;
import com.bysj.drm.service.Memberservice;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MemberserviceImpl implements Memberservice {
	@Autowired
	private MemberDao memberDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Member> getAllByPage(Page page, MemberCond cond) {
		return memberDao.getAllByPage(page, cond);
	}

	@Override
	@Transactional(readOnly = true)
	public Member getMemberByid(Integer id) {
		return memberDao.getMemberByid(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateMember(Member member) {
		return memberDao.UpdateMember(member);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delMember(Integer id) {
		return memberDao.delMember(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Member> getAllByMemberTypeId(Integer id) {
		return memberDao.getAllByMemberTypeId(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int AddMember(Member member) {
		return memberDao.AddMember(member);
	}

	@Override
	public int flagMemberByphone(String phone) {
		Member member = memberDao.getMemberByphone(phone);
		if(member != null){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateMemberByphone(String phone, Integer code) {
		return memberDao.UpdateMemberByphone(phone, code);
	}

}
