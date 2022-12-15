package sky.pro.questionforexamspring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.questionforexamspring.model.Question;
import sky.pro.questionforexamspring.service.ExaminerServiceImpl;
import sky.pro.questionforexamspring.service.QuestionService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTests {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

 //   private Set<Question> actualQuestions;

    @BeforeEach
    public void setUp(){
        Question question1 = new Question("question1", "answer1");
//        Question question2 = new Question("question2", "answer2");
//        Question question3 = new Question("question3", "answer3");
//        Question question4 = new Question("question4", "answer4");

 //       actualQuestions = new HashSet<>(Set.of(question1, question2, question3, question4));

        //when(questionService.getAllQuestion().size()).thenReturn(actualQuestions.size());
        when(questionService.getAllQuestion().size()).thenReturn(4);
        when(questionService.getRandomQuestion()).thenReturn(question1);
    }



    @Test
    public void checkGetQuestions() {
        final int amount = 1;
        final Question question1 = new Question("question1", "answer1");
       // final Question question2 = new Question("question2", "answer2");
        final Collection<Question> standard = new HashSet<>(Set.of(question1));

        final Collection<Question> checked = examinerService.getQuestions(amount);

        assertEquals(checked, standard);
    }

    @Test
    public void checkExceptionWhenGetQuestions() {
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(6));
    }

}
