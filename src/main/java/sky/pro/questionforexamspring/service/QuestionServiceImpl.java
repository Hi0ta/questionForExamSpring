package sky.pro.questionforexamspring.service;

import org.springframework.stereotype.Service;
import sky.pro.questionforexamspring.exception.FieldsShouldNotBeEmptyException;
import sky.pro.questionforexamspring.model.Question;
import sky.pro.questionforexamspring.record.QuestionRequest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService{
    private Set<Question> questions = new HashSet<>();

    public QuestionServiceImpl(Set<Question> questions) {this.questions = questions;}

    @Override
    public Question add(Question question) {
        if (questions.contains(question)){
            throw new IllegalArgumentException("такие вопрос/ответ уже существуют");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question add(String questionStr, String answerStr) {
        if(questionStr == null || answerStr == null){
        throw new FieldsShouldNotBeEmptyException("поля вопрос и/или ответ должны быть заполнены");
        }
        Question question = new Question(questionStr, answerStr);

        questions.add(question);
        return question;
    }





    @Override
    public Collection<Question> getAllQuestion() {
        return this.questions;
    }

    @Override
    public Question removeQuestion(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Question getRandomQuestion() {
    java.util.Random random = new java.util.Random();
    int index = random.nextInt(questions.size()-1);
        Question question = new Question("q", "a");
    // questions.stream().filter(questions -> questions.getQuestion().hashCode() == index).get();

     return question;
    }
}
