package kz.epam.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends CommonEntity {
    @Column(name = "email")
    private String email;
}
