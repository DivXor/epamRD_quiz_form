package kz.epam.quiz.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by admin on 11/27/2015.
 */
public class AnswerDTO {
    @NotEmpty(message = "Answer cannot be empty")
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
