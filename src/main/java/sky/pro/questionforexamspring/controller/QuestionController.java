package sky.pro.questionforexamspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.questionforexamspring.exception.AbsenceArgumentException;
import sky.pro.questionforexamspring.exception.FieldsShouldNotBeEmptyException;
import sky.pro.questionforexamspring.model.Question;
import sky.pro.questionforexamspring.service.QuestionService;


import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

//    @ExceptionHandler(value = ThisArgumentAlreadyExistsException.class)
//    public ResponseEntity<String> ThisArgumentAlreadyExistsHandler(ThisArgumentAlreadyExistsException e) {
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }

    @ExceptionHandler(value = FieldsShouldNotBeEmptyException.class)
    public ResponseEntity<String> FieldsShouldNotBeEmptyHandler(FieldsShouldNotBeEmptyException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String questionStr,
                        @RequestParam("answer") String answerStr) {
        return service.add(questionStr, answerStr);
    }

    @ExceptionHandler(value = AbsenceArgumentException.class)
    public ResponseEntity<String> AbsenceArgumentHandler(AbsenceArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @GetMapping("")
    public Collection<Question> getAllQuestion() {
        return service.getAllQuestion();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String questionStr,
                                   @RequestParam("answer") String answerStr) {
        return service.removeQuestion(questionStr, answerStr);
    }

}
