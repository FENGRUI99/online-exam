package com.fengrui.controller;

import com.fengrui.pojo.TeaUser;
import com.fengrui.pojo.User;
import com.fengrui.service.TeaUserService;
import com.fengrui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TeaUserService teaUserService;
    @GetMapping("/toTeacher")
    public String toTeaLogin(){
        return "teacher/login";
    }
    @GetMapping("/toStuLogin")
    public String toStuLogin(){
        return "student/login";
    }

    @PostMapping("/stuLogin")
    public String stuLogin(String username, String userpwd, HttpServletRequest servletRequest){
        User login = userService.login(username, userpwd);
        if (login == null){
            servletRequest.getSession().setAttribute("msg","密码错误");
            return "redirect:/toStuLogin";
        }
        else {
            System.out.println("登陆成功");
            return "student/StuMan";
        }
    }

    @PostMapping("/teaLogin")
    public String teaLogin(String username, String userpwd, HttpServletRequest servletRequest){
        TeaUser login = teaUserService.login(username, userpwd);
        if (login == null){
            servletRequest.getSession().setAttribute("msg","密码错误");
            return "redirect:/toTeacher";
        }
        else {
            System.out.println("登陆成功");
            servletRequest.getSession().setAttribute("Teatruename",login.getRealName());
            servletRequest.getSession().setAttribute("TeaClassid", login.getClassId());
            servletRequest.getSession().setAttribute("Teauserid", login.getClassId());
            return "teacher/manage";
        }
    }
}
