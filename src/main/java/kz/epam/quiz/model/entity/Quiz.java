package kz.epam.quiz.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quizzes")
public class Quiz extends AbstractEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "creation_time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Column(name = "expiration_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationTime;

    @Column(name = "anonymous")
    private boolean anonymous;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Set<Answer> answers = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "history",
            joinColumns = {@JoinColumn(name = "quiz_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
//        for (Answer answer: answers) {
//            answer.setQuiz(this);
//        }
        this.answers = answers;
    }

    public boolean isAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
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

    public void addAnswer(Answer answer){
        answer.setQuiz(this);
        answers.add(answer);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationTime=" + creationTime +
                ", expirationTime=" + expirationTime +
                ", anonymous=" + anonymous +
                ", status=" + status +
                ", author=" + author +
                ", answers=" + answers +
                ", answeredUsers=" + answeredUsers +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quiz quiz = (Quiz) o;

        if (anonymous != quiz.anonymous) return false;
        if (status != quiz.status) return false;
        if (title != null ? !title.equals(quiz.title) : quiz.title != null) return false;
        if (content != null ? !content.equals(quiz.content) : quiz.content != null) return false;
        if (creationTime != null ? !creationTime.equals(quiz.creationTime) : quiz.creationTime != null) return false;
        if (expirationTime != null ? !expirationTime.equals(quiz.expirationTime) : quiz.expirationTime != null)
            return false;
        if (author != null ? !author.equals(quiz.author) : quiz.author != null) return false;
        if (answers != null ? !answers.equals(quiz.answers) : quiz.answers != null) return false;
        return !(answeredUsers != null ? !answeredUsers.equals(quiz.answeredUsers) : quiz.answeredUsers != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (anonymous ? 1 : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        result = 31 * result + (answeredUsers != null ? answeredUsers.hashCode() : 0);
        return result;
    }
}
