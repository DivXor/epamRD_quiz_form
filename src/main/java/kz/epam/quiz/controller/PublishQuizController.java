package kz.epam.quiz.controller;

import kz.epam.quiz.controller.dto.PublishAnswerDTO;
import kz.epam.quiz.controller.dto.PublishQuizDTO;
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
        PublishQuizDTO publishQuizDTO = new PublishQuizDTO();
        model.put("publishQuizDTO", publishQuizDTO);
        return "publish";
    }

    @RequestMapping(value = "/quiz/publish", method = RequestMethod.POST)
    public String doPublishForm(@Valid @ModelAttribute("publishQuizDTO") PublishQuizDTO publishForm, BindingResult result,
                                Map<String, Object> model) {

        validateAnswers(publishForm.getAnswerForms(), result);

        if (result.hasErrors()) {
            return "publish";
        }

        //AbstractDao service = new UserService();
        //service.persist();
        //quizService.persist();

        return "publish";
    }

    private BindingResult validateAnswers(List<PublishAnswerDTO> answerForms, BindingResult result) {
        if (answerForms.isEmpty())
            result.addError(new FieldError("Answer", "", "Answers cannot be empty"));
        Iterator iterator = answerForms.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            PublishAnswerDTO publishAnswer = (PublishAnswerDTO) iterator.next();
            Set<ConstraintViolation<PublishAnswerDTO>> validationList = validator.validate(publishAnswer);
            for (ConstraintViolation<PublishAnswerDTO> violation : validationList) {
                String path = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                result.addError(new FieldError("Answer", "answerForms[" + index + "]" + "." + path, "Answer: " + message));
            }
            index++;
        }
        return result;
    }
}
