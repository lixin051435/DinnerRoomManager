package com.bysj.drm.controller;

import com.bysj.drm.common.CommonPage;
import com.bysj.drm.common.CommonResults;
import com.bysj.drm.entity.DiningTable;
import com.bysj.drm.service.DiningTableservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/20 15:46
 */
@Controller
public class DiningTableController {

    @Autowired
    private DiningTableservice diningTableservice;


    @ResponseBody
    @RequestMapping("/getTable")
    public CommonResults list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        CommonPage<DiningTable> diningTableCommonPage = CommonPage.restPage(diningTableservice.getAlldiningTable(page, limit));
        return CommonResults.success(diningTableCommonPage.getTotal().intValue(), diningTableCommonPage.getList());

    }


    /**
     * 跳转编辑餐桌
     *
     * @param upid
     * @param modelAndView
     * @return
     */
    @RequestMapping("/getTableUpInfo")
    public ModelAndView getTableUpInfo(Integer upid, ModelAndView modelAndView) {
        modelAndView.addObject("diningTable", diningTableservice.getOneTable(upid));
        modelAndView.setViewName("/DTable/Addcanzhuo");
        return modelAndView;
    }


    @RequestMapping("/updateTable")
    public ModelAndView updateTable(DiningTable diningTable, ModelAndView modelAndView) {
        System.out.println(diningTable);
        int i = diningTableservice.UpdateDiningTable(diningTable);
        if (i > 0) {
            modelAndView.setViewName("DTable/canzhuo");
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping("/addTable")
    public CommonResults addTable(DiningTable diningTable) {
        diningTable.setIsno(0);
        int addDiningTable = diningTableservice.addDiningTable(diningTable);
        return addDiningTable == 1 ? CommonResults.success() : CommonResults.failure();

    }


}
