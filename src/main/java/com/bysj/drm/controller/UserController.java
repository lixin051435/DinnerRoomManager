package com.bysj.drm.controller;

import com.bysj.drm.common.CommonPage;
import com.bysj.drm.common.CommonResults;
import com.bysj.drm.dto.UserCond;
import com.bysj.drm.entity.Users;
import com.bysj.drm.service.Usersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/20 22:21
 */
@Controller
public class UserController {

    @Autowired
    private Usersservice usersservice;


    @ResponseBody
    @RequestMapping("/getallusers")
    public CommonResults getallusers(@RequestParam("page") Integer page,
                                     @RequestParam("limit") Integer limit, UserCond cond) {

        CommonPage<Users> usersCommonPage = CommonPage.restPage(usersservice.getAllUsers(page, limit, cond));
        return CommonResults.success(usersCommonPage.getTotal().intValue(), usersCommonPage.getList());
    }


    @ResponseBody
    @RequestMapping("/Adduser")
    public CommonResults Adduser(Users users) {
        System.out.println("users = " + users);
        int addUser = usersservice.addUser(users);
        return addUser == 1 ? CommonResults.success() : CommonResults.failure();
    }

    @RequestMapping("/getoneUser")
    public ModelAndView updateuser(ModelAndView modelAndView, @RequestParam("uid") Integer id) {
        modelAndView.addObject("Upuser", usersservice.getOneuser(id));
        modelAndView.setViewName("/employee/Addyuangong");
        return modelAndView;
    }

    @RequestMapping("/updateuser")
    public void updateuser(HttpServletResponse response, Users users) throws IOException {
        System.out.println("users = " + users);
        PrintWriter writer = response.getWriter();
        if (users.getId() != null) {
            int updateUser = usersservice.UpdateUser(users);
            if (updateUser > 0) {
                writer.print("<script>alert('success');location.href='/DinnerRoomManager/yuangong';</script>");
            }
            writer.print("<script>alert('failure');location.href='/DinnerRoomManager/getoneUser?uid="
                    + users.getId() + "';</script>");
        } else {
            int addUser = usersservice.addUser(users);
            if (addUser > 0) {
                writer.print("<script>alert('success');location.href='/DinnerRoomManager/yuangong';</script>");
            }
            writer.print("<script>alert('failure');location.href='/DinnerRoomManager/getoneUser?uid="
                    + users.getId() + "';</script>");
        }
    }

    @ResponseBody
    @RequestMapping("/deluser")
    public CommonResults deluser(@RequestParam("delid") Integer id) {
        Users oneuser = usersservice.getOneuser(id);
        if (oneuser.getULoginname().equals("admin")) {
            return CommonResults.failure("管理员不能删除！");
        }
        int delUser = usersservice.delUser(id);
        return delUser == 1 ? CommonResults.success() : CommonResults.failure();

    }

    @ResponseBody
    @RequestMapping("/upuserpwd")
    public CommonResults updatePwd(@RequestParam("uid") Integer id,
                                   @RequestParam("Uppwd") String Uppwd) {
        int upUserPwd = usersservice.UpUserPwd(id, Uppwd);
        return upUserPwd == 1 ? CommonResults.success() : CommonResults.failure();
    }

}
