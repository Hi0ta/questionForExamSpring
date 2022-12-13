package sky.pro.questionforexamspring.service;

import org.springframework.stereotype.Service;
import sky.pro.questionforexamspring.model.Question;

import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService{
   // private Random random;
    private QuestionService questionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
