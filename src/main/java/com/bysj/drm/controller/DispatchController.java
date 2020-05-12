package com.bysj.drm.controller;

import com.bysj.drm.entity.DiningTable;
import com.bysj.drm.entity.Menu;
import com.bysj.drm.entity.MenuType;
import com.bysj.drm.service.DiningTableservice;
import com.bysj.drm.service.MenuTypeservice;
import com.bysj.drm.service.Menuservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/20 12:27
 */
@Slf4j
@Controller
public class DispatchController {

    @Autowired
    private DiningTableservice diningTableservice;

    @Autowired
    private Menuservice menuservice;

    @Autowired
    private MenuTypeservice menuTypeservice;

    @RequestMapping("/index")
    public String login() {
        return "index";
    }

    @RequestMapping("/addcanzhuo")
    public String Addcanzhuo() {

        return "DTable/Addcanzhuo";
    }

    @RequestMapping("/canzhuo")
    public String canzhuo() {
        return "DTable/canzhuo";
    }

    @RequestMapping("/yuangong")
    public String emp() {
        return "employee/yuangong";
    }

    @RequestMapping("/addyuangong")
    public String addyuangong() {
        return "employee/Addyuangong";
    }

    @RequestMapping("/welcome")
    public String welcome() {
//        return "dayinfo";
        return "redirect:/dayinfo";
    }


    @RequestMapping("/caipu")
    public String grees() {
        return "grees/caipu";
    }

    @RequestMapping("/addcaipu")
    public String addCaipu() {
        return "grees/Addcaipu";
    }

    @RequestMapping("/caiputype")
    public String caiputype() {
        return "grees/caiputype";
    }


    @RequestMapping("/dingdan")
    public String dingdan() {
        return "order/dingdan";
    }

    @RequestMapping("/systemInfo")
    public String systemInfo() {
        return "system/SystemInfo";
    }

    @RequestMapping("/updataPwd")
    public String updataPwd() {
        return "system/UpdataPwd";
    }

    @RequestMapping("/chart")
    public String chart() {
        return "chart/chart";
    }

    @RequestMapping("/diancan")
    public String MemberPlate() {
        return "qiantai/diancan";
    }

    @RequestMapping("/OrderMenu")
    public String OrderMenu(ModelMap modelMap) {
        List<DiningTable> diningTables = diningTableservice.getdiningTable();
        modelMap.addAttribute("dtList", diningTables);
        List<Menu> allMenu = menuservice.getAllMenu();
        List<MenuType> allMenuType = menuTypeservice.getAllMenuType();
        Map<String, Object> mtlist = new HashMap<>();
        mtlist.put("menuTypelist", allMenuType);
        mtlist.put("menuLists", allMenu);
        modelMap.addAttribute("mtlist", mtlist);
        return "qiantai/OrderMenu";
    }

    @RequestMapping("/OrderInfo")
    public String OrderInfo() {
        return "qiantai/OrderInfo";
    }

    @RequestMapping("/orderJieSuan")
    public String orderJieSuan() {
        return "qiantai/orderJieSuan";
    }

    @RequestMapping("/canzuosyqk")
    public String canzuosyqk(ModelMap modelMap) {
        List<DiningTable> diningTables = this.diningTableservice.getdiningTable();
        modelMap.addAttribute("dtableList", diningTables);
        return "qiantai/canzuosyqk";
    }

}
