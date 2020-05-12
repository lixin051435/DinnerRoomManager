package com.bysj.drm.controller;

import com.bysj.drm.common.CommonPage;
import com.bysj.drm.common.CommonResults;
import com.bysj.drm.dto.DinnerOrderCond;
import com.bysj.drm.entity.DinnerOrder;
import com.bysj.drm.service.DiningTableservice;
import com.bysj.drm.service.DinnerOrderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/20 16:49
 */
@Controller
public class OrderController {

    @Autowired
    private DinnerOrderservice dinnerOrderservice;

    @ResponseBody
    @RequestMapping("/getAllOrder")
    public CommonResults getAllOrder(@RequestParam("page") Integer page,
                                     @RequestParam("limit") Integer limit,
                                     DinnerOrderCond cond
    ) {
        CommonPage<DinnerOrder> dinnerOrderCommonPage = CommonPage.restPage(dinnerOrderservice.getAllDinnerOrder(page, limit, cond));
        return CommonResults.success(dinnerOrderCommonPage.getTotal().intValue(), dinnerOrderCommonPage.getList());
    }

    @ResponseBody
    @RequestMapping("/getAllnoticeByid")
    public ArrayList getAllnoticeByid(@RequestParam("id") Integer id) {
        DinnerOrder dinnerOrder = dinnerOrderservice.getAllnoticeByid(id);
        if (dinnerOrder != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(dinnerOrder);
            return arrayList;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/delOrder")
    public CommonResults delete(@RequestParam("delid") Integer id) {
        int delOrderInfo = dinnerOrderservice.delOrderInfo(id);
        return delOrderInfo == 1 ? CommonResults.success() : CommonResults.failure();
    }

}
