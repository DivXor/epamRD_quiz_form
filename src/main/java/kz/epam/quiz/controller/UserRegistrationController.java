//package kz.epam.quiz.controller;
//
//import kz.epam.quiz.model.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by admin on 11/27/2015.
// */
//@Controller
//public class UserRegistrationController {
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(path = "/registration", method = RequestMethod.POST)
//    public String doRegistration(HttpServletRequest request) {
//        String referer = request.getHeader("Referer");
//        return "redirect:" + referer;
//    }
//}
