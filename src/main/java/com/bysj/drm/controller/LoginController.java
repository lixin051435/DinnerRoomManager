package com.bysj.drm.controller;

import com.bysj.drm.common.CommonResults;
import com.bysj.drm.entity.Users;
import com.bysj.drm.service.Usersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author linSir
 * @version V1.0
 * @Date 2020/2/21 16:45
 */
@Controller
public class LoginController {


    @Autowired
    private Usersservice usersservice;


    @RequestMapping("/loginView")
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public CommonResults loginDo(String logname, String logpass, HttpSession session) {
        Users users = usersservice.LoginUser(logname);
        if (!ObjectUtils.isEmpty(users)) {
            if (!users.getUPwd().equals(logpass)) {
                return CommonResults.failure("errorPwd");
            } else {
                session.setAttribute("user", users);
                session.setAttribute("uLoginname",users.getULoginname());
                session.setAttribute("uName",users.getUName());
                return CommonResults.success(users);
            }
        }
        return CommonResults.failure("error");
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }


}
