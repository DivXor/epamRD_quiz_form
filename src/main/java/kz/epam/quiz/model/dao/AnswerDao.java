package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerDao extends JpaRepository<Answer, Integer> {

}
