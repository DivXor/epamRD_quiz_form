package kz.epam.quiz.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_messages")
public class QuizMailoutMessage extends AbstractEntity {
    @Column
    private String title;
    @Column
    private String content;
    @Column(name = "sent_time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    private Set<User> answeredUsers;

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

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<User> getAnsweredUsers() {
        return answeredUsers;
    }

    public void setAnsweredUsers(Set<User> answeredUsers) {
        this.answeredUsers = answeredUsers;
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

        QuizMailoutMessage that = (QuizMailoutMessage) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (sentTime != null ? !sentTime.equals(that.sentTime) : that.sentTime != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (quiz != null ? !quiz.equals(that.quiz) : that.quiz != null) return false;
        return !(answeredUsers != null ? !answeredUsers.equals(that.answeredUsers) : that.answeredUsers != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (sentTime != null ? sentTime.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (quiz != null ? quiz.hashCode() : 0);
        result = 31 * result + (answeredUsers != null ? answeredUsers.hashCode() : 0);
        return result;
    }
}
