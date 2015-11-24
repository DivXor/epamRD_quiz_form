package kz.epam.quiz.controller.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by admin on 11/24/2015.
 */
public class PublishQuizForm {
    @NotEmpty(message = "Title cannot be empty")
    @Size(max = 200)
    private String title;
    @NotEmpty(message = "Content cannot be empty")
    @Size(max=1000)
    private String content;

    @NotNull(message = "Answers cannot be null")
    private List<PublishAnswerForm> answerForms;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PublishAnswerForm> getAnswerForms() {
        return answerForms;
    }

    public void setAnswerForms(List<PublishAnswerForm> answerForms) {
        this.answerForms = answerForms;
    }
}
