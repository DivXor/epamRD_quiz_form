package kz.epam.quiz.controller.dto;

import javax.validation.constraints.NotNull;
import java.util.*;

public class QuizDTO {
    @NotNull
    private List<AnswerDTO> answersList = new ArrayList<>();

    public List<AnswerDTO> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<AnswerDTO> answersList) {
        this.answersList = answersList;
    }
}
