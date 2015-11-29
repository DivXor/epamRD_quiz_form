package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryDao extends JpaRepository<History, Integer> {

}
