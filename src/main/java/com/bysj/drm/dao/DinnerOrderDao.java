package com.bysj.drm.dao;

import com.bysj.drm.dto.DayInfo;
import com.bysj.drm.dto.DinnerOrderCond;
import com.bysj.drm.entity.DinnerOrder;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;


public interface DinnerOrderDao {


    @Select("select sum(price) as totalPrice,sum(personnum) as totalPersonNumber ,count(id) as totalOrderNumber from dinner_order where ordertime between #{day1}  and #{day2}")
    DayInfo getDayInfo(@Param("day1") String day1, @Param("day2")String day2);

    //多条件分页查询数据
    List<DinnerOrder> getAllDinnerOrder(DinnerOrderCond cond);

    //删除
    @Delete("delete from dinner_order where id=#{id} ")
    int delOrderInfo(Integer id);

    //后厨查询菜单详情
    List<DinnerOrder> getAllDinnerOrderByhouchu(Page page);

    //后厨上菜已经齐全
    @Update("update dinner_order set isfull = 1,ispay = 1 where id = #{id}")
    int UpdateisFull(Integer id);

    //添加订单
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO dinner.dinner_order ( table_id, ordertime, usercode, personnum, ispay, price, isfull) VALUES " +
            "( #{tableId} , #{ordertime} , #{usercode} , #{personnum} , #{ispay} , #{price} , #{isfull} )")
    int addOrder(DinnerOrder order);

    //前台结算订单页查询
    List<DinnerOrder> getAllDinnerOrderByQT(DinnerOrderCond cond);

    //订单结算
    int updateOrder(Integer oid, Double price);

    //计算报表信息
    String homeInfo();

    @Select("select *from dinner_order where id=#{id} ")
    DinnerOrder getAllnoticeByid(Integer id);

    @Select("select * from dinner_order where ordertime between #{day1}  and #{day2}")
    List<DinnerOrder> getStatChart(@Param("day1") String day1, @Param("day2") String day2);

    @Select("select * from dinner_order where to_days(ordertime) = to_days(now());")
    List<DinnerOrder> getThisDate();
}
