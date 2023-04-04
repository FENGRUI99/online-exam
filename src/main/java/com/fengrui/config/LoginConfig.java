//package com.fengrui.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册登陆拦截器
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
//        //拦截所有路径
//        interceptorRegistration.addPathPatterns("/**");
//        //不用拦截的路径
//        interceptorRegistration.excludePathPatterns(
//                "/css/**",
//                "/fonts/**",
//                "/img/**",
//                "/js/**",
//                "/",
//                "/student/login.html",
//                "/teacher/login.html",
//                "student/register.html",
//                "/toTeacher",
//                "/toStuLogin",
//                "/stuLogin",
//                "/teaLogin",
//                "/register",
//                "/CanRegister");
//    }
//}
