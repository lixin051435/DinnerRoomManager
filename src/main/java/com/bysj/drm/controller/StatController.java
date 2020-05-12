package com.bysj.drm.controller;

import com.bysj.drm.common.CommonResults;
import com.bysj.drm.entity.DinnerOrder;
import com.bysj.drm.service.DinnerOrderservice;
import com.bysj.drm.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/21 12:30
 */
@Controller
public class StatController {

    @Autowired
    private DinnerOrderservice dinnerOrderservice;

    @ResponseBody
    @RequestMapping("/stat/loadOpernamedateTime")
    public CommonResults listData(@RequestParam("day1") String day1, @RequestParam("day2") String day2) {

        //查询当天数据
        if (day1.equals(day2)) {
            day2 = day1 + " 23:59:59";
        }
        //查询时间区间数据
        List<DinnerOrder> statChart = dinnerOrderservice.getStatChart(day1, day2);

        // 分别代表周一到周日的销售额
        Integer[] value = new Integer[7];
        for (int i = 0; i < 7; i++) {
            value[i] = 0;
        }

        for (DinnerOrder order :
                statChart) {
            int day = DateUtils.getWeekOfDate(order.getOrdertime());
            value[day] += order.getPrice();
        }


        //value = clearArray(value);
        return CommonResults.success(value);
    }

    private Integer[] clearArray(Integer[] value) {
        return new Integer[7];
    }


}
