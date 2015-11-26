package kz.epam.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by admin on 11/25/2015.
 */
@Controller
public class QuizController {
    @RequestMapping(value = "/quiz/view/{id}", method = RequestMethod.GET)
    public String viewQuiz(@PathVariable Integer id, Map<String, Object> model) {
        model.put("quiz_id", id);
        return "quiz";
    }

    @RequestMapping(value = "/quiz/view/{id}", method = RequestMethod.POST)
    public String doAnswerQuiz(Map<String, Object> model) {
        model.put("answered", "1");
        return "quiz";
    }
}
