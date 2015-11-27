package kz.epam.quiz.controller;

import kz.epam.quiz.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by admin on 11/27/2015.
 */
@Controller
public class UserRegistrationController {
    @Autowired
    private UserService userService;


    public String doRegistration() {

        return "";
    }
}
