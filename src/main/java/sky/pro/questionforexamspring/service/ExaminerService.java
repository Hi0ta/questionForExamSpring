package sky.pro.questionforexamspring.service;

import sky.pro.questionforexamspring.model.Question;
import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
