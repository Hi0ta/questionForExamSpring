package sky.pro.questionforexamspring.service;

import org.springframework.stereotype.Service;
import sky.pro.questionforexamspring.model.Question;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAllQuestion().size()) {
            throw new IllegalArgumentException("В списке недостаточное количество вопросов");
        }
        Collection<Question> result = new HashSet<>();

        while (amount > result.size()) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }

}
