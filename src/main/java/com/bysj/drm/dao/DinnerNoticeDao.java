package com.bysj.drm.dao;

import com.bysj.drm.entity.DinnerNotice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DinnerNoticeDao {
    //根据id查询所有小票信息
    @Select("select *from dinner_notice  where id=#{id} ")
    List<DinnerNotice> getAllDinnerNoticeByID(Integer id);

    //删除订单编号下的小票
    @Delete("delete from dinner_notice  where order_id=#{oid} ")
    int delNotice(Integer oid);

    //添加小票
    @Insert("INSERT INTO `dinner`.`dinner_notice`( `menu_name`, `order_id`, `menunum`, `remark`, `menuprice`) VALUES ( #{menuName} , #{orderId} , #{menunum} , #{remark} , #{menuprice} );")
    int addNotice(DinnerNotice notice);
}
