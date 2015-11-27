package kz.epam.quiz.controller.form;

import javax.validation.constraints.NotNull;
import java.util.*;

public class QuizForm {
    @NotNull
    private List<AnswerForm> answersList = new ArrayList<>();

    public List<AnswerForm> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<AnswerForm> answersList) {
        this.answersList = answersList;
    }
}
