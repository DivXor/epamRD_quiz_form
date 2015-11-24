package kz.epam.quiz.controller.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PublishAnswerForm {
    //@NotEmpty(message = "Title cannot be empty")
 //   @Size(max = 200)
    private String title;
  //  @NotEmpty(message = "Type cannot be empty")
    private String type;
 //   @NotNull(message = "Order cannot be null")
    private Integer order;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
