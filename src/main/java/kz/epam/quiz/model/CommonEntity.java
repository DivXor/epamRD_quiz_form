package kz.epam.quiz.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class CommonEntity {
    
    @Column(name = "id")
    private @Id @GeneratedValue int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
