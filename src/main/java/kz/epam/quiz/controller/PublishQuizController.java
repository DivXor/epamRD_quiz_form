package kz.epam.quiz.controller;

import kz.epam.quiz.controller.form.PublishAnswerForm;
import kz.epam.quiz.controller.form.PublishQuizForm;
import kz.epam.quiz.model.dao.test.AbstractDao;
import kz.epam.quiz.model.dao.test.QuizService;
import kz.epam.quiz.model.dao.test.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.*;
import java.util.*;


@Controller
public class PublishQuizController {

    private Validator validator;

    public PublishQuizController() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @RequestMapping(value = "/quiz/publish", method = RequestMethod.GET)
    public String viewPublishForm(Map<String, Object> model) {
        model.put("title", "Publish new quiz");
        PublishQuizForm publishQuizForm = new PublishQuizForm();
        model.put("publishQuizForm", publishQuizForm);
        return "publish";
    }

    @RequestMapping(value = "/quiz/publish", method = RequestMethod.POST)
    public String doPublishForm(@Valid @ModelAttribute("publishQuizForm") PublishQuizForm publishForm, BindingResult result,
                                Map<String, Object> model) {

        validateAnswers(publishForm.getAnswerForms(), result);

        if (result.hasErrors()) {
            return "publish";
        }

        AbstractDao service = new UserService();
        //service.persist();
        //quizService.persist();

        return "publish";
    }

    private BindingResult validateAnswers(List<PublishAnswerForm> answerForms, BindingResult result) {
        if (answerForms.isEmpty())
            result.addError(new FieldError("Answer", "", "Answers cannot be empty"));
        Iterator iterator = answerForms.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            PublishAnswerForm publishAnswer = (PublishAnswerForm) iterator.next();
            Set<ConstraintViolation<PublishAnswerForm>> validationList = validator.validate(publishAnswer);
            for (ConstraintViolation<PublishAnswerForm> violation : validationList) {
                String path = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                result.addError(new FieldError("Answer", "answerForms[" + index + "]" + "." + path, "Answer: " + message));
            }
            index++;
        }
        return result;
    }
}
