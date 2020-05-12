package com.bysj.drm.controller;

import com.bysj.drm.common.CommonPage;
import com.bysj.drm.common.CommonResults;
import com.bysj.drm.dto.DayInfo;
import com.bysj.drm.dto.DinnerOrderCond;
import com.bysj.drm.entity.DinnerOrder;
import com.bysj.drm.entity.Menu;
import com.bysj.drm.service.DiningTableservice;
import com.bysj.drm.service.DinnerOrderservice;
import com.bysj.drm.service.Memberservice;
import com.bysj.drm.service.Menuservice;
import com.bysj.drm.util.DateUtils;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/21 14:59
 */
@Controller
public class DinCanController {

    @Autowired
    private DinnerOrderservice dinnerOrderservice;

    @Autowired
    private DiningTableservice diningTableservice;
    @Autowired
    private Menuservice menuservice;

    @Autowired
    private Memberservice memberservice;

    @RequestMapping("/dayinfo")
    public ModelAndView getDayInfo() {
        List<DayInfo> infos = new ArrayList<>();
        String day1 = DateUtils.format(new Date());
        String day2 = day1 + " 23:59:59";
        DayInfo today_info = dinnerOrderservice.getDayInfo(day1, day2);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        Date yestoday = calendar.getTime();
        String yestoday_day1 = DateUtils.format(yestoday);
        String yestoday_day2 = yestoday_day1 + " 23:59:59";
        DayInfo yestoday_info = dinnerOrderservice.getDayInfo(yestoday_day1, yestoday_day2);


        ModelAndView modelAndView = new ModelAndView("dayinfo");

        modelAndView.addObject("today",today_info);
        modelAndView.addObject("yestoday",yestoday_info);

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/dingcan")
    public CommonResults dingcan(String tableid, String userCode, Integer personNum, String ids, String counts, String ranks) {
        DinnerOrder dinnerOrder = new DinnerOrder();
        dinnerOrder.setTableId(tableid);
        dinnerOrder.setUsercode(userCode);
        dinnerOrder.setPersonnum(personNum);
        Integer countPrice = 0;
        String[] split = ids.split(",");
        String[] countsStr = counts.split(",");
        if (split.length != countsStr.length) {
            System.out.println("食品和食品类型数量不一致");
        }
        for (int i = 0; i < split.length; i++) {
            Menu menuBy = menuservice.getMenuByid(Integer.parseInt(split[i]));
            int count = Integer.parseInt(countsStr[i]);
            int price = menuBy.getMPrice() * count;
            countPrice += price;
        }
        dinnerOrder.setPrice(countPrice);
        dinnerOrder.setIspay(0);
        dinnerOrder.setOrdertime(new Date());
        dinnerOrder.setIsfull(0);
        int addOrder = dinnerOrderservice.addOrder(dinnerOrder);
        return addOrder == 1 ? CommonResults.success() : CommonResults.failure();
    }

    @ResponseBody
    @RequestMapping("/getAllOrderInfo")
    public CommonResults getAllOrderInfo(@RequestParam("page") Integer page,
                                         @RequestParam("limit") Integer limit) {
        CommonPage<DinnerOrder> dinnerOrderCommonPage = CommonPage.restPage(dinnerOrderservice.getAllDinnerOrder(page, limit, null));
        return CommonResults.success(dinnerOrderCommonPage.getTotal().intValue(), dinnerOrderCommonPage.getList());

    }


    @ResponseBody
    @RequestMapping("/getnoticeByid")
    public ArrayList getnoticeByid(@RequestParam("id") Integer id) {

        DinnerOrder allnoticeByid = dinnerOrderservice.getAllnoticeByid(id);
        if (!ObjectUtils.isEmpty(allnoticeByid)) {
            ArrayList list = new ArrayList();
            list.add(allnoticeByid);
            return list;
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("/OrderJieSuan")
    public CommonResults OrderJieSuan(@RequestParam("page") Integer page,
                                      @RequestParam("limit") Integer limit,
                                      @RequestParam(required = false) String startTime,
                                      @RequestParam(required = false) String endTime,
                                      @RequestParam(required = false) Integer ispay) {
        DinnerOrderCond cond = new DinnerOrderCond();
        cond.setStartTime(startTime);
        cond.setEndTime(endTime);
        if (ispay == null || ispay == -1) {
            ispay = null;
        }
        cond.setPay(ispay);
        CommonPage<DinnerOrder> dinnerOrderCommonPage = CommonPage.restPage(dinnerOrderservice.getAllDinnerOrder(page, limit, cond));
        return CommonResults.success(dinnerOrderCommonPage.getTotal().intValue(), dinnerOrderCommonPage.getList());

    }

    @ResponseBody
    @RequestMapping("/JieSuan")
    public Integer OrderJieSuan2(@RequestParam("oid") Integer oid,
                                 @RequestParam(name = "mphone", required = false) String mphone) {

        if (mphone == null || mphone.length() == 0) {
            return dinnerOrderservice.UpdateisFull(oid);
        } else {
            int flag = memberservice.flagMemberByphone(mphone);
            if (flag == 1) {
                return dinnerOrderservice.UpdateisFull(oid);
            } else {
                return -2;
            }
        }

    }


    @ResponseBody
    @RequestMapping("/jiuzuo")
    public CommonResults jiuzuo(@RequestParam("tabid") Integer id) {
        int updateisFull = this.diningTableservice.updateTableIsNo(id);
        return updateisFull == 1 ? CommonResults.success() : CommonResults.failure();
    }
}
