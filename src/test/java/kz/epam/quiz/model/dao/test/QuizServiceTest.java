package kz.epam.quiz.model.dao.test;

import kz.epam.quiz.model.entity.Answer;
import kz.epam.quiz.model.entity.Quiz;
import kz.epam.quiz.model.entity.User;
import kz.epam.quiz.util.SpringWebAppConfig;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringWebAppConfig.class })
@Transactional
public class QuizServiceTest {

    @Autowired
    private QuizService quizService;

    @Test
    public void testGetList() throws Exception {
        List<Quiz> users = quizService.getList();
        System.out.println(users);
    }

    @Test
    public void testGetById() throws Exception {
        Quiz quiz = quizService.getByKey(1);
        System.out.println(quiz);
    }

    @Rollback(value = false)
    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setId(1);
        user.setEmail("test@test.com");

        Set<Answer> answers = new HashSet<>();
        Answer answer = new Answer();
        answer.setTitle("sdfsdf");
        answer.setType("one");
        answer.setAnswerOrder(1);
        answers.add(answer);

        Quiz quiz = new Quiz();
        quiz.setTitle("err");
        quiz.setContent("test");
        quiz.setExpirationTime(new Date());
        quiz.setAnonymous(true);
        quiz.setStatus(true);
        quiz.setUser(user);
        quiz.setAnswers(answers);

        quizService.persist(quiz);
    }

    @Rollback(value = false)
    @Test
    public void testDelete() throws Exception {
        Quiz quiz = new Quiz();
        quiz.setId(1);
        quizService.delete(quiz);
    }

}