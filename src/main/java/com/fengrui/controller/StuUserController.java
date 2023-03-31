package com.fengrui.controller;

import com.fengrui.pojo.Class;
import com.fengrui.pojo.User;
import com.fengrui.service.ClassService;
import com.fengrui.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StuUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ClassService classService;

    @GetMapping("/register")
    public String toRegister(Model model){
        List<Class> cLasses = classService.getAll();
        model.addAttribute("list", cLasses);
        return "student/register";
    }

    @PostMapping("/CanRegister")
    public String register(User user, String username, String  userpwd, String truename, Integer classid, HttpServletRequest request){
        user.setUsername(username);
        user.setPassword(userpwd);
        user.setRealName(truename);
        user.setClassId(classid);
        if (userService.getByName(username).size() > 0){
            System.out.println("user exists!");
            return "redirect:/register";
        }
        else {
            if(userService.register(user) > 0) {
                return "redirect:/toStuLogin";
            }
            else {
                System.out.println("register fail");
                return "redirect:/register";
            }

        }

    }
}
