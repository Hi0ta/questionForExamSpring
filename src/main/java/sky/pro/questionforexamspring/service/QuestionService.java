package sky.pro.questionforexamspring.service;

import sky.pro.questionforexamspring.model.Question;
import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question removeQuestion(String questionStr, String answerStr);

    Collection<Question> getAllQuestion();

    Question getRandomQuestion();

}
