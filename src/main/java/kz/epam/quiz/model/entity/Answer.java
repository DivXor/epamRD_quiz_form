package kz.epam.quiz.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "answers")
public class Answer extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Column(name = "answer_order")
    private int answerOrder;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "quizzes_id", insertable = false, updatable = false, nullable = false)
    private Quiz quiz;

    @ManyToMany(mappedBy = "userAnswers", fetch = FetchType.LAZY)
    private Set<User> answeredUsers;

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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Set<User> getAnsweredUsers() {
        return answeredUsers;
    }

    public void setAnsweredUsers(Set<User> answeredUsers) {
        this.answeredUsers = answeredUsers;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerOrder=" + answerOrder +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (answerOrder != answer.answerOrder) return false;
        if (title != null ? !title.equals(answer.title) : answer.title != null) return false;
        if (type != null ? !type.equals(answer.type) : answer.type != null) return false;
        return !(quiz != null ? !quiz.equals(answer.quiz) : answer.quiz != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + answerOrder;
        result = 31 * result + (quiz != null ? quiz.hashCode() : 0);
        return result;
    }


}
