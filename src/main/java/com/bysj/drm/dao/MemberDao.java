package com.bysj.drm.dao;

import com.bysj.drm.dto.MemberCond;
import com.bysj.drm.entity.Member;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface MemberDao {
	//分页查询所有
	List<Member> getAllByPage(Page page, MemberCond cond);
	//根据id查询对象
	Member getMemberByid(Integer id);
	//修改
	int UpdateMember(Member member);
	//删除
	int delMember(Integer id);
	//根据会员类型获取集合
	List<Member> getAllByMemberTypeId(Integer id);
	//添加会员
	int AddMember(Member member);
	//添加会员时根据手机号判断数据库是否存在
	@Select("select * from member where phone = #{phone}")
	Member getMemberByphone(String phone);
	//根据会员手机号修改积分
	int UpdateMemberByphone(String phone, Integer code);
}
