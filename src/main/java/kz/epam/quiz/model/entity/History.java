package kz.epam.quiz.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @Column(name = "answer_time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date answerTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
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

        History history = (History) o;

        if (user != null ? !user.equals(history.user) : history.user != null) return false;
        if (answer != null ? !answer.equals(history.answer) : history.answer != null) return false;
        if (quiz != null ? !quiz.equals(history.quiz) : history.quiz != null) return false;
        return !(answerTime != null ? !answerTime.equals(history.answerTime) : history.answerTime != null);

    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (quiz != null ? quiz.hashCode() : 0);
        result = 31 * result + (answerTime != null ? answerTime.hashCode() : 0);
        return result;
    }
}
