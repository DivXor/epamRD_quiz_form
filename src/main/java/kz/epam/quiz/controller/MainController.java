package kz.epam.quiz.controller;

import kz.epam.quiz.controller.form.PublishAnswerForm;
import kz.epam.quiz.controller.form.PublishQuizForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewPageMain(Map<String, Object> model) {
        model.put("title", "Publish new quiz");
        PublishQuizForm publishQuizForm = new PublishQuizForm();

        List<PublishAnswerForm> answerForms = new ArrayList<>();

        PublishAnswerForm publishAnswerForm = new PublishAnswerForm();
        publishAnswerForm.setTitle("test");
        publishAnswerForm.setType("many");
        publishAnswerForm.setOrder(1);

        answerForms.add(publishAnswerForm);

        publishAnswerForm = new PublishAnswerForm();
        publishAnswerForm.setTitle("asdfasdf");
        publishAnswerForm.setType("one");
        publishAnswerForm.setOrder(2);
        answerForms.add(publishAnswerForm);


        publishQuizForm.setAnswerForms(answerForms);
        model.put("publishQuizForm", publishQuizForm);
        return "publish";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String doActionMain(@Valid @ModelAttribute("publishQuizForm") PublishQuizForm publishForm, BindingResult result,
                               Map<String, Object> model){

        Iterator iterator = publishForm.getAnswerForms().iterator();

        while (iterator.hasNext()) {
            PublishAnswerForm publishAnswer = (PublishAnswerForm)iterator.next();

        }


        if(result.hasErrors()) {
            System.out.println(publishForm.getAnswerForms().get(0).getTitle());
            return "publish";
        }


        return "index";
    }


}
