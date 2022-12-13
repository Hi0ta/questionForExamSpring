package sky.pro.questionforexamspring.service;

import sky.pro.questionforexamspring.model.Question;
import sky.pro.questionforexamspring.record.QuestionRequest;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);
    Question add(String question, String answer);
    Question removeQuestion(Question question);
    Collection<Question> getAllQuestion();
    Question  getRandomQuestion();

}
