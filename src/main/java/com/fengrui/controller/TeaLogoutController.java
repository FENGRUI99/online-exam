package com.fengrui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeaLogoutController {
    @GetMapping("/Tlogout")
    public String logout(HttpServletRequest servletRequest){
        servletRequest.getSession().removeAttribute("Teatruename");
        servletRequest.getSession().removeAttribute("TeaClassid");
        servletRequest.getSession().removeAttribute("Teauserid");
        return "redirect:/toTeacher";
    }
}
