package com.fengrui.controller;

import com.fengrui.pojo.User;
import com.fengrui.service.ClassService;
import com.fengrui.service.TeaUserService;
import com.fengrui.pojo.Class;
import com.fengrui.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TeaUserController {
    @Autowired
    ClassService classService;
    @Autowired
    UserService userService;
    //查询所有学生信息
    @GetMapping("/StudentList")
    public String findUsers(HttpServletRequest request, Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        //获取班级id
        Integer classId = Integer.valueOf((String) request.getSession().getAttribute("TeaClassid"));

        //获取教师所在班级
        model.addAttribute("pj",classService.getClassById(classId));

        //设置分页
        PageHelper.startPage(pageNum,5);

        //查询学生列表
        List<User> users = userService.pageByClassId(classId);
        PageInfo<User> usersPageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo",usersPageInfo);
        model.addAttribute("liss",users);

        //获取所有班级信息
        List<Class> allPClass = classService.getAll();
        model.addAttribute("list",allPClass);

        return "teacher/StudentList";
    }

    //添加学生
    @PostMapping("/addStu")
    public String addUser(User user, String username,String userpwd,String truename, Integer classid){
        //判断学生是否存在
        if (userService.getByName(username).size() == 0){
            user.setUsername(username);
            user.setPassword(userpwd);
            user.setRealName(truename);
            user.setClassId(classid);
            //添加学生
            userService.register(user);
            System.out.println("添加成功");
        }
        else{
            System.out.println("学生已存在");
        }
        return "redirect:/StudentList";
    }

    //查询所有班级
    @ResponseBody
    @PostMapping("/findAllClass")
    public List<Class> getAllClass(){
        return classService.getAll();
    }

    //查询用户信息
    @ResponseBody
    @PostMapping("/StuEdit")
    public User findUser(@RequestBody User user){
        return userService.getById(user.getId());
    }

    //修改用户信息
    @PostMapping("/updateStu")
    public String updateUser(User user){
        System.out.println(user.toString());
        System.out.println(userService.update(user));
        return "redirect:/StudentList";
    }

    //删除用户信息
    @GetMapping("/deleteStu")
    public String deleteUser(HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("userid"));
        System.out.println(id);
        System.out.println(userService.delete(id));
        return "redirect:/StudentList";
    }

    //删除改班级所有学生
    @GetMapping("/deleteAll")
    public String deleteAll(HttpServletRequest request){
        Integer classId = Integer.valueOf((String) request.getSession().getAttribute("TeaClassid"));
        userService.deleteAll(classId);
        return "redirect:/StudentList";
    }
}
