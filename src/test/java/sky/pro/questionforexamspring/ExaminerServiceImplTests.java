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

    @Test
    public void checkGetQuestions() {
        final int amount = 1;
        final Question question1 = new Question("question1", "answer1");
        final Collection<Question> standard = new HashSet<>(Set.of(question1));
        when(questionService.getAllQuestion()).thenReturn(standard);
        when(questionService.getRandomQuestion()).thenReturn(question1);
        final Collection<Question> checked = examinerService.getQuestions(amount);
        assertEquals(checked, standard);
    }

    @Test
    public void checkExceptionWhenGetQuestions() {
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(6));
    }

}
