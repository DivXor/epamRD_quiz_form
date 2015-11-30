package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Query("SELECT h.user FROM History h WHERE h.answer.id = :id")
    List<User> findUsersByAnswerId(@Param("id") int id);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
    boolean isExistsByEmail(@Param("email") String email);

}
