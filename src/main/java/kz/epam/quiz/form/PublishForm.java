package kz.epam.quiz.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * Created by admin on 11/24/2015.
 */
public class PublishForm {
    @NotEmpty
    @Size(max = 200)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
