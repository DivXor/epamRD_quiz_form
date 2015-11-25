package kz.epam.quiz.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "USERS", schema = "DIVON")
public class User extends AbstractEntity {

    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }
}
