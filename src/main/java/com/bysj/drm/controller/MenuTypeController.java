package com.bysj.drm.controller;

import com.bysj.drm.common.CommonPage;
import com.bysj.drm.common.CommonResults;
import com.bysj.drm.entity.MenuType;
import com.bysj.drm.service.MenuTypeservice;
import com.bysj.drm.service.Menuservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/20 21:22
 */
@Controller
public class MenuTypeController {

    @Autowired
    private MenuTypeservice typeservice;

    @ResponseBody
    @RequestMapping("/getallMenuType")
    public CommonResults getallMenuType(@RequestParam("page") Integer page,
                                        @RequestParam("limit") Integer limit) {
        CommonPage<MenuType> menuTypeCommonPage = CommonPage.restPage(typeservice.getAllMenuTypeBypage(page, limit));
        return CommonResults.success(menuTypeCommonPage.getTotal().intValue(), menuTypeCommonPage.getList());

    }

    @ResponseBody
    @RequestMapping("/addMenuType")
    public CommonResults addMenuType(@RequestParam("type_name") String typeName) {
        System.out.println("typeName = " + typeName);
        MenuType menuType = new MenuType();
        menuType.setTypeName(typeName);
        int addMenuType = typeservice.addMenuType(menuType);
        return addMenuType == 1 ? CommonResults.success() : CommonResults.failure();
    }


    @ResponseBody
    @RequestMapping("/delmenuType")
    public CommonResults delmenuType(@RequestParam("delid") Integer id) {
        int delMenuType = typeservice.delMenuType(id);
        return delMenuType == 1 ? CommonResults.success() : CommonResults.failure();
    }



}
