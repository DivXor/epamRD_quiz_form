package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.Quiz;
import kz.epam.quiz.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

    @Query("SELECT q FROM Quiz q JOIN Answer a JOIN History h WHERE h.user.id = :id")
    List<Quiz> findByAnsweredUsers(@Param("id") int quizId);
}
