package kz.epam.quiz.controller;

import kz.epam.quiz.form.PublishForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewPageMain(Map<String, Object> model) {
        model.put("publishForm", new PublishForm());
        return "publish";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String doActionMain(@ModelAttribute("publishForm") PublishForm publishForm, BindingResult bindingResult,
                               Map<String, Object> model){
        return "publish";
    }


}
