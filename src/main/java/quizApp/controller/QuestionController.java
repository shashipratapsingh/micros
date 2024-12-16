package quizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizApp.Model.Question;
import quizApp.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionService.addQuestion(question));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question questionDetails) {
        return ResponseEntity.ok(questionService.updateQuestion(id, questionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<List<Question>> addQuestions(@RequestBody Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
        questionService.addQuestion(question); // Save the question
        List<Question> allQuestions = questionService.getAllQuestions(); // Fetch all questions
        return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }
}
