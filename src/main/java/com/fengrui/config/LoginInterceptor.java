//package com.fengrui.config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //学生id
//        Integer userid = (Integer) request.getSession().getAttribute("id");
//        //教师id
//        Integer teauserid = (Integer) request.getSession().getAttribute("Teauserid");
//
//        String uri = request.getRequestURI();
//        System.out.println(userid);
//        System.out.println(teauserid);
//        System.out.println(uri);
//        if (userid != null){
//            if (!(uri.equals("/StudentList"))&&!(uri.equals("/DeleteStu"))&&
//                    !(uri.equals("/deleteAll"))&&!(uri.equals("/finddanxuan"))&&
//                    !(uri.equals("/addSingle"))&&!(uri.equals("/selectexam"))&&
//                    !(uri.equals("/addexam"))&&!(uri.equals("/paperDetails"))&&
//                    !(uri.equals("/deleteExam"))&&!(uri.equals("/findAllScore")))
//                return true;
//        }
//        else if (teauserid != null){
//            if (!(uri.equals("/examList"))&&!(uri.equals("/paper"))&&
//                    !(uri.equals("/findAllStuPaper"))&&!(uri.equals("/StuMan"))) {
//                return true;
//            }
//        }
//        response.sendRedirect(request.getContextPath()+"/toStuLogin");
//        request.getSession().removeAttribute("id");
//        request.getSession().removeAttribute("Teauserid");
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
//}
