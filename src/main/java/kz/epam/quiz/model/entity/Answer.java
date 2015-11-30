package kz.epam.quiz.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "answer_order")
    private int answerOrder;

    @ManyToOne
    @JoinColumn(name = "quiz_id", insertable = false, updatable = false)
    private Quiz quiz;

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

    public int getAnswerOrder() {
        return answerOrder;
    }

    public void setAnswerOrder(int answerOrder) {
        this.answerOrder = answerOrder;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", answerOrder=" + answerOrder +
                "} " + super.toString();
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (answerOrder != answer.answerOrder) return false;
        if (title != null ? !title.equals(answer.title) : answer.title != null) return false;
        return !(type != null ? !type.equals(answer.type) : answer.type != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + answerOrder;
        return result;
    }
}
