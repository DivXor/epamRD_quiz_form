//package kz.epam.quiz.controller;
//
//import kz.epam.quiz.controller.form.AnswerForm;
//import kz.epam.quiz.controller.form.QuizForm;
//import kz.epam.quiz.model.entity.User;
//import kz.epam.quiz.model.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.validation.*;
//import java.util.*;
//
//@Controller
//public class QuizController {
//    private Validator validator;
//
//    @Autowired
//    private UserService userService;
//
//    public QuizController() {
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = validatorFactory.getValidator();
//    }
//
//    @RequestMapping(value = "/quiz/view/{id}", method = RequestMethod.GET)
//    public String viewQuiz(@PathVariable Integer id, Map<String, Object> model) {
//        model.put("quizForm", new QuizForm());
//        model.put("quiz_id", id);
//        return "quiz";
//    }
//
//    @RequestMapping(value = "/quiz/view/{id}", method = RequestMethod.POST)
//    public String doQuiz(@PathVariable Integer id, @Valid @ModelAttribute("quizForm") QuizForm quizForm, BindingResult result, Map<String, Object> model) {
//        model.put("quiz_id", id);
//        validateAnswers(quizForm.getAnswersList(), result);
//
//        if(!result.hasErrors()) {
//            model.put("answered", "1");
//        }
//
//        return "quiz";
//    }
//
//    @RequestMapping(value = "/quiz/view/{id}/answer/{answer_id}", method = RequestMethod.GET)
//    public String viewVotedUsers(Map<String, Object> model) {
//        List<User> userList = new ArrayList<>();
//        model.put("answered", "1");
//        model.put("userList", userList);
//        return "quiz";
//    }
//
//    private BindingResult validateAnswers(List<AnswerForm> answerForms, BindingResult result) {
//        if (answerForms.isEmpty())
//            result.addError(new FieldError("Answer", "", "Answers cannot be empty"));
//        Iterator iterator = answerForms.iterator();
//        int index = 0;
//        while (iterator.hasNext()) {
//            AnswerForm answerForm = (AnswerForm) iterator.next();
//            Set<ConstraintViolation<AnswerForm>> validationList = validator.validate(answerForm);
//            for (ConstraintViolation<AnswerForm> violation : validationList) {
//                String path = violation.getPropertyPath().toString();
//                String message = violation.getMessage();
//                result.addError(new FieldError("Answer", "answersList[" + index + "]" + "." + path, "Answer: " + message));
//            }
//            index++;
//        }
//        return result;
//    }
//}
