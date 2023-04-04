package com.fengrui.controller;

import com.fengrui.dao.QuestionDao;
import com.fengrui.pojo.*;
import com.fengrui.pojo.Class;
import com.fengrui.service.*;
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
    @Autowired
    QuestionService questionService;
    @Autowired
    CourseService courseService;
    @Autowired
    ExamService examService;
    @Autowired
    ExamQuestionMediaService examQuestionMediaService;
    @Autowired
    ExamStudentMediaService examStudentMediaService;
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

    //查询所有题目
    @GetMapping("/finddanxuan")
    public String findQuestion(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, Model model){
        PageHelper.startPage(pageNum, 5);
        List<Question> quetions = questionService.findAll();
        for (Question q: quetions){
            Course allById = courseService.getById(q.getCourseId());
            q.setCourse(allById);
        }
        PageInfo<Question> questionPageInfo = new PageInfo<>(quetions);
        model.addAttribute("pageInfo", questionPageInfo);
        model.addAttribute("subjectlist", quetions);
        return "teacher/Single";
    }
    //获取所有课程
    @ResponseBody
    @GetMapping("/findAllCourse")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    //添加试题
    @PostMapping("/addSingle")
    public String addQuestion(Question question){
        System.out.println(question.toString());
        questionService.addQuestion(question);
        return "redirect:/finddanxuan";
    }

    //查找试题通过id
    @ResponseBody
    @PostMapping("/findBySid")
    public Question findById(@RequestBody Question question){
        return questionService.findById(question.getId());
    }

    //修改试题
    @PostMapping("/updateSingle")
    public String updateQuestion(Question question){
        questionService.updateQuestion(question);
        return "redirect:/finddanxuan";
    }

    //删除试题
    @PostMapping("/deleteSingle")
    public String deleteQuestion(@RequestParam Integer id){
        questionService.deleteQuestion(id);
        return "redirect:/finddanxuan";
    }

    @GetMapping("/selectexam")
    public String selectExam(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,Model model){
        PageHelper.startPage(pageNum,5);
        List<Exam> allExam = examService.getAll();
        PageInfo<Exam> examPageInfo = new PageInfo<>(allExam);
        model.addAttribute("examlist",allExam);
        model.addAttribute("pageInfo",examPageInfo);
        return "teacher/SelectExam";
    }

    @GetMapping("/addexam")
    public String toAddExam(){
        return "teacher/addexam";
    }

    //创建考试
    @PostMapping("/addexams")
    public String addExam(Exam exam){
        examService.addExam(exam);
        examQuestionMediaService.addExamQuestion(exam.getId(), exam.getCourseId(), exam.getQuestionNumber());
        return "teacher/addexam";
    }
    @ResponseBody
    @GetMapping("/findAllClasses")
    public List<Class> getAllClasses(){
        return classService.getAll();
    }
    @ResponseBody
    @PostMapping("/findByOneExam")
    public Exam findExamById(@RequestBody Exam exam){
        return examService.getById(exam.getId());
    }

    @GetMapping("/deleteExam")
    public String deleteExam(Integer id){
        examQuestionMediaService.deleteById(id);
        examService.deleteExam(id);
        return "redirect:/selectexam";
    }
    @PostMapping("/updateExam")
    public String updateExam(Exam exam){
        examQuestionMediaService.updateExamQuestion(exam.getId(), exam.getCourseId(), exam.getQuestionNumber());
        examService.updateExam(exam);
        return "redirect:/selectexam";
    }

    @GetMapping("/paperDetails")
    public  String paperDetails(Integer id,Model model){
        Integer examId = id;
        List<ExamQuestionMedia> examQuestions = examQuestionMediaService.getByExamId(examId);
        model.addAttribute("tm",examQuestions);
        Exam exam = examService.getById(examId);
        System.out.println(exam.toString());
        model.addAttribute("exam",exam);
        return "teacher/paperDetails";
    }

    @GetMapping("/findAllScore")
    public String findAllScore(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpServletRequest request,Model model){
        PageHelper.startPage(pageNum,5);
        //获取class id
        Integer teaClassid = Integer.valueOf((String) request.getSession().getAttribute("TeaClassid"));
        model.addAttribute("cs",classService.getClassById(teaClassid));
        List<ExamStudentMedia> scores = examStudentMediaService.findByClassId(teaClassid);
        for (ExamStudentMedia score : scores){
            score.setUser(userService.getById(score.getUserId()));
        }
        PageInfo<ExamStudentMedia> studentexamPageInfo = new PageInfo<>(scores);
        model.addAttribute("pageInfo",studentexamPageInfo);
        model.addAttribute("score",scores);
        return "teacher/AllScore";
    }

}
