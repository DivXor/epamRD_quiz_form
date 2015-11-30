package kz.epam.quiz.model.dao;

import kz.epam.quiz.model.entity.Answer;
import kz.epam.quiz.model.entity.Quiz;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.util.SpringDataConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataConfig.class})
@Transactional
public class QuizDaoTest {

    @Autowired
    QuizDao quizDao;

    @Rollback(value = true)
    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setId(1);

        Set<Answer> answers = new HashSet<>();
        Answer answer = new Answer();
        answer.setTitle("testAnswer");
        answer.setType("one");
        answer.setAnswerOrder(1);

        Answer answer2 = new Answer();
        answer2.setTitle("testAnswer");
        answer2.setType("many");
        answer2.setAnswerOrder(2);

        answers.add(answer);
        answers.add(answer2);

        Quiz quiz = new Quiz();
        quiz.setTitle("testQuiz");
        quiz.setContent("testContent");
        quiz.setExpirationTime(new Date());
        quiz.setAnonymous(false);
        quiz.setStatus(true);
        quiz.setAuthor(user);
        quiz.setAnswers(answers);

        quizDao.saveAndFlush(quiz);
    }

    @Test
    public void testFindByAnsweredUsers() throws Exception {
        List<Quiz> quizs = quizDao.findByAnsweredUsers(1);
    }
}