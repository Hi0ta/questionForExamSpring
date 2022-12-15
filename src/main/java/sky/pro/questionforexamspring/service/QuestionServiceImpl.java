package sky.pro.questionforexamspring.service;

import org.springframework.stereotype.Service;
import sky.pro.questionforexamspring.exception.AbsenceArgumentException;
import sky.pro.questionforexamspring.exception.FieldsShouldNotBeEmptyException;
import sky.pro.questionforexamspring.model.Question;
import java.util.*;


@Service
public class QuestionServiceImpl implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private Random random = new Random();

    @Override
    public Question add(String questionStr, String answerStr) {
        if (!questionStr.equals("null") && !answerStr.equals("null")) {
            Question question = new Question(questionStr, answerStr);
            questions.add(question);
            return question;
        }
        throw new FieldsShouldNotBeEmptyException("поля вопрос и/или ответ должны быть заполнены");
    }

    @Override
    public Question add(Question question) {
//        if (questions.contains(question)) {
//            throw new ThisArgumentAlreadyExistsException("такая пара вопрос/ответ уже существуют");
//        }
        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(String questionStr, String answerStr) {
        for (Question question : questions)
            if (question.getQuestion().contains(questionStr) && question.getAnswer().contains(answerStr)) {
                questions.remove(question);
                return question;
            }
        throw new AbsenceArgumentException("Такой пары вопрос/ответ нет");
    }

    @Override
    public Collection<Question> getAllQuestion() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int index = random.nextInt(questions.size() - 1);
        List<Question> result = questions.stream().toList();
        return result.get(index);
    }
}
