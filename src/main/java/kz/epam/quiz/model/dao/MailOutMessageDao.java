package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.MailOutMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailOutMessageDao extends JpaRepository<MailOutMessage, Integer> {

}
