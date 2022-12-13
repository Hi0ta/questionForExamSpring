package sky.pro.questionforexamspring.service;

import sky.pro.questionforexamspring.model.Question;
import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
//    java.util.Random random = new java.util.Random();
//    int index = random.nextInt(size);



//    public static int generateRandomInt() {
//        java.util.Random random = new java.util.Random();
//        int randomInt = random.nextInt(99);
//        return randomInt;
//    }
}
