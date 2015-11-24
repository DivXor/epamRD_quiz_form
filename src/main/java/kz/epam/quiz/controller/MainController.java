package kz.epam.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewPageMain(Map<Object, String> model) {
        System.out.println("heello");
        return "index";
    }
}
