package com.fengrui.controller;

import com.fengrui.pojo.*;
import com.fengrui.service.CourseService;
import com.fengrui.service.ExamQuestionMediaService;
import com.fengrui.service.ExamService;
import com.fengrui.service.ExamStudentMediaService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class ExamController {
    @Autowired
    ExamService examService;
    @Autowired
    CourseService courseService;
    @Autowired
    ExamQuestionMediaService examQuestionMediaService;
    @Autowired
    ExamStudentMediaService examStudentMediaService;
    @GetMapping("/examList")
    public String examList(HttpServletRequest request, Model model){
        Integer classid = (Integer) request.getSession().getAttribute("classid");
        List<Exam> exams = examService.getByClassId(classid);
        model.addAttribute("examslenth",exams.size());
        model.addAttribute("exams",exams);
        return "student/examList";
    }

    // 是否做过考试，如果做了会有考试记录
    @ResponseBody
    @PostMapping("/findOneStuExam")
    public ExamStudentMedia findOneExam(HttpServletRequest request, @RequestBody Exam exam){
        Integer userid = (Integer) request.getSession().getAttribute("id");
        return examStudentMediaService.findByTwoId(exam.getId(), userid);
    }

    @ResponseBody
    @PostMapping("/findExamById")
    public Exam findExamById(@RequestBody Exam exam){
        return examService.getById(exam.getId());
    }

    @GetMapping("/paper")
    public String getPaperById(Integer examId, HttpServletRequest request,Model model){
        List<ExamQuestionMedia> examQuestionMedias = examQuestionMediaService.getByExamId(examId);
        Exam exam = examService.getById(examId);
        Course course = courseService.getById(exam.getCourseId());
        exam.setCourse(course);
        request.getSession().setAttribute("single", examQuestionMedias);
        model.addAttribute("cont",examQuestionMedias.size());
        model.addAttribute("exam",exam);
        return "/student/papers";
    }

    //显示考试成绩
    @PostMapping("/PaperScore")
    public String paperScore(HttpServletRequest request,Model model){
        ExamStudentMedia examStudentMedia = new ExamStudentMedia();
        Integer classId = (Integer) request.getSession().getAttribute("classid");
        Integer userId = (Integer) request.getSession().getAttribute("id");
        String examName = request.getParameter("examName");
        String time = request.getParameter("tjtime");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp.valueOf(time);
        Integer examId = Integer.valueOf(request.getParameter("id"));
        List<ExamQuestionMedia> questions = (List<ExamQuestionMedia>) request.getSession().getAttribute("single");
        Exam exam = examService.getById(examId);
        int totalScore = 0;
        int score = 0;
        for (ExamQuestionMedia question : questions){
            if (question.getAnswer().equals(request.getParameter(String.valueOf(question.getId())))){
                score += Integer.valueOf(exam.getSingleScore());
            }
            totalScore += Integer.valueOf(exam.getSingleScore());
        }

        examStudentMedia.setUserId(userId);
        examStudentMedia.setClassId(classId);
        examStudentMedia.setExamId(examId);
        examStudentMedia.setExamName(examName);
        examStudentMedia.setScore(score);
        examStudentMedia.setTotalScore(totalScore);
        examStudentMedia.setTime(timestamp);
        model.addAttribute("score",score);
        examStudentMediaService.addExamStudent(examStudentMedia);
        return "student/paperScore";
    }

    @GetMapping("/findAllStuPaper")
    public String findAllPaper(HttpServletRequest request,Model model){
        Integer userid = (Integer) request.getSession().getAttribute("id");
        List<ExamStudentMedia> studentexams = examStudentMediaService.findByUserId(userid);
        model.addAttribute("stuexamlist",studentexams);
        return "student/stuPaperList";
    }

    //解决点击在线考试报错
    @GetMapping("/StuMan")
    public String getStuMan(){
        return "student/StuMan";
    }
}
