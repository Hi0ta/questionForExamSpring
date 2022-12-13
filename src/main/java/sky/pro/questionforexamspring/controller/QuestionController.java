package sky.pro.questionforexamspring.controller;

import org.springframework.web.bind.annotation.*;
import sky.pro.questionforexamspring.model.Question;
import sky.pro.questionforexamspring.service.QuestionServiceImpl;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    QuestionServiceImpl questionServiceImpl;

@GetMapping("/add")
public Question addQuestionAnswer(@RequestParam("question") String questionStr,
                                    @RequestParam("answer") String answerStr){
        return questionServiceImpl.add(questionStr, answerStr);
    }


}
