package kz.epam.quiz.controller;

import kz.epam.quiz.controller.dto.AnswerDTO;
import kz.epam.quiz.controller.dto.QuizDTO;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.model.service.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.*;
import java.util.*;

@Controller
public class QuizController {
    private Validator validator;

    @Autowired
    private UserService userService;

    public QuizController() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @RequestMapping(value = "/quiz/view/{id}", method = RequestMethod.GET)
    public String viewQuiz(@PathVariable Integer id, Map<String, Object> model) {
        model.put("quizDTO", new QuizDTO());
        model.put("quiz_id", id);
        return "quiz";
    }

    @RequestMapping(value = "/quiz/view/{id}", method = RequestMethod.POST)
    public String doQuiz(@PathVariable Integer id, @Valid @ModelAttribute("quizDTO") QuizDTO quizDTO, BindingResult result, Map<String, Object> model) {
        model.put("quiz_id", id);
        validateAnswers(quizDTO.getAnswersList(), result);

        if(!result.hasErrors()) {
            model.put("answered", "1");
        }

        return "quiz";
    }

    @RequestMapping(value = "/quiz/view/{id}/answer/{answer_id}", method = RequestMethod.GET)
    public String viewVotedUsers(Map<String, Object> model) {
        List<User> userList = new ArrayList<>();
        model.put("answered", "1");
        model.put("userList", userList);
        return "quiz";
    }

    private BindingResult validateAnswers(List<AnswerDTO> answerDTOs, BindingResult result) {
        if (answerDTOs.isEmpty())
            result.addError(new FieldError("Answer", "", "Answers cannot be empty"));
        Iterator iterator = answerDTOs.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            AnswerDTO answerDTO = (AnswerDTO) iterator.next();
            Set<ConstraintViolation<AnswerDTO>> validationList = validator.validate(answerDTO);
            for (ConstraintViolation<AnswerDTO> violation : validationList) {
                String path = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                result.addError(new FieldError("Answer", "answerDTOs[" + index + "]" + "." + path, "Answer: " + message));
            }
            index++;
        }
        return result;
    }
}
