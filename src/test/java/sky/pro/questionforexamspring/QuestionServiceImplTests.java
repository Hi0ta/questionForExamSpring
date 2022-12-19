package sky.pro.questionforexamspring;

import org.junit.jupiter.api.Test;
import sky.pro.questionforexamspring.exception.AbsenceArgumentException;
import sky.pro.questionforexamspring.exception.FieldsShouldNotBeEmptyException;
import sky.pro.questionforexamspring.model.Question;
import sky.pro.questionforexamspring.service.QuestionServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionServiceImplTests {
    private QuestionServiceImpl questionService = new QuestionServiceImpl();
    private final Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    @Test
    public void checkAdd() {
        final String questionStr = "question1";
        final String answerStr = "answer1";
        final Question standard = new Question(questionStr, answerStr);
        final Question checked = questionService.add(questionStr, answerStr);
        assertEquals(checked, standard);
    }

    @Test
    public void checkExceptionWhenAdd() {
        assertThrows(FieldsShouldNotBeEmptyException.class, () -> questionService.add(" ", " "));
    }

    @Test
    public void checkAddQuestion() {
        final Question standard = new Question("question1", "answer1");
        final Question checked = questionService.add(standard);

        assertEquals(checked, standard);
    }

    @Test
    public void checkRemoveQuestion() {
        final String questionStr = "question1";
        final String answerStr = "answer1";
        final Question standard = new Question(questionStr, answerStr);
        questionService.add(standard);
        Question checked = questionService.removeQuestion(questionStr, answerStr);

        assertEquals(checked, standard);
    }

    @Test
    public void checkExceptionWhenRemoveQuestion() {
        assertThrows(AbsenceArgumentException.class, () -> questionService.removeQuestion("question10", "answer10"));
    }

    @Test
    public void checkGetAllQuestion(){
        final Question question1 = new Question("question1", "answer1");
        questionService.add(question1);
        questions.add(question1);
        final Question question2 = new Question("question2", "answer2");
        questionService.add(question2);
        questions.add(question2);

        assertIterableEquals(questionService.getAllQuestion(), questions);
    }

    @Test
    public void checkGetRandomQuestion() {
        final Question question1 = new Question("question1", "answer1");
        questionService.add(question1);
        final Question question2 = new Question("question2", "answer2");
        questionService.add(question2);

        assertNotNull(questionService.getRandomQuestion());
    }
}
