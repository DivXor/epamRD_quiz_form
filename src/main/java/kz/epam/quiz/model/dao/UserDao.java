package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("SELECT h.user FROM History h WHERE h.answer.id = :id")
    List<User> findUsersByAnswerId(@Param("id") int id);
}
