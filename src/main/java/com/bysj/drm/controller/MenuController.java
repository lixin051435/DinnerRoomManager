package com.bysj.drm.controller;

import com.bysj.drm.common.CommonPage;
import com.bysj.drm.common.CommonResults;
import com.bysj.drm.dto.MenuCond;
import com.bysj.drm.entity.Menu;
import com.bysj.drm.entity.MenuType;
import com.bysj.drm.service.MenuTypeservice;
import com.bysj.drm.service.Menuservice;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/20 20:24
 */
@Controller
public class MenuController {

    @Autowired
    private Menuservice menuservice;


    @RequestMapping("/addMenu")
    public void addMenu(@RequestParam MultipartFile upload, HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        //获取后缀位置
        int extIndex = upload.getOriginalFilename().lastIndexOf(".");
        //获取后缀
        String substring = upload.getOriginalFilename().substring(extIndex);

        String uuid = UUID.randomUUID().toString().replace("-", "");

        String fileName = uuid + substring;

        Menu menu = new Menu();
        String mname = request.getParameter("mname");
        String mprice = request.getParameter("mprice");
        String typeid = request.getParameter("typeid");
        String remark = request.getParameter("remark");

        menu.setMName(mname);
        menu.setMPrice(Integer.valueOf(mprice));
        menu.setTypeId(Integer.valueOf(typeid));
        menu.setImagePath(fileName);
        menu.setRemark(remark);

        InputStream inputStream = null;

        FileOutputStream fos = null;
        try {
            inputStream = upload.getInputStream();
            int b = 0;
            String path = "F:\\IdeaProject\\DinnerRoomManager\\src\\main\\webapp\\upload";


            fos = new FileOutputStream(path + "//" + fileName);
            //  一次读取一个字节数组
            while ((b = inputStream.read()) != -1) {

                fos.write(b);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        int addMenu = menuservice.AddMenu(menu);
        if (addMenu > 0) {
            writer.print("<script>alert('success');</script>");
        } else {
            writer.print("<script>alert('failure');</script>");
        }
    }

    @RequestMapping("/updateMenuInfo")
    public void updateMenuInfo(HttpServletResponse response, @RequestParam MultipartFile upload, HttpServletRequest request) throws IOException {

        //获取后缀位置
        int extIndex = upload.getOriginalFilename().lastIndexOf(".");
        //获取后缀
        String substring = upload.getOriginalFilename().substring(extIndex);

        String uuid = UUID.randomUUID().toString().replace("-", "");

        String fileName = uuid + substring;

        Menu menu = new Menu();
        String menuid = request.getParameter("menuid");
        String mname = request.getParameter("mname");
        String mprice = request.getParameter("mprice");
        String typeid = request.getParameter("typeid");
        String remark = request.getParameter("remark");

        menu.setId(Integer.valueOf(menuid));
        menu.setMName(mname);
        menu.setMPrice(Integer.valueOf(mprice));
        menu.setTypeId(Integer.valueOf(typeid));
        menu.setImagePath(fileName);
        menu.setRemark(remark);

        InputStream inputStream = null;

        FileOutputStream fos = null;
        try {
            inputStream = upload.getInputStream();
            int b = 0;
            String path = "F:\\IdeaProject\\DinnerRoomManager\\src\\main\\webapp\\upload";


            fos = new FileOutputStream(path + "//" + fileName);
            //  一次读取一个字节数组
            while ((b = inputStream.read()) != -1) {

                fos.write(b);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        PrintWriter writer = response.getWriter();
        int updateMenu = menuservice.updateMenu(menu);
        if (updateMenu > 0) {
            writer.print("<script>alert('success');</script>");
        } else {
            writer.print("<script>alert('failure');</script>");
        }
    }

    @ResponseBody
    @RequestMapping("/getallmenu")
    public CommonResults list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "limit",defaultValue = "10") Integer limit, MenuCond cond) {
        System.out.println("cond = " + cond.getM_name());
        CommonPage<Menu> menuCommonPage = CommonPage.restPage(menuservice.menuList(page, limit, cond));
        return CommonResults.success(menuCommonPage.getTotal().intValue(), menuCommonPage.getList());
    }


    @RequestMapping("/getUpdateMenuInfo")
    public ModelAndView getUpdateMenuInfo(@RequestParam("getUpMenuInfoid") Integer id, ModelAndView modelAndView) {
        Menu menu = menuservice.getMenuByid(id);
        modelAndView.addObject("updateMenuInfo", menu);
        modelAndView.setViewName("/grees/Addcaipu");
        return modelAndView;

    }

}
