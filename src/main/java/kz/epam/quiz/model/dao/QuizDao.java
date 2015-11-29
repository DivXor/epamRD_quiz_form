package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
