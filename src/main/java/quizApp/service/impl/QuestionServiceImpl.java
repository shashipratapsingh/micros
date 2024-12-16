package quizApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quizApp.Model.Question;
import quizApp.repository.QuestionRepo;
import quizApp.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

        public List<Question> getAllQuestions() {
            return questionRepo.findAll();
        }

        public Question getQuestionById(Long id) {
            if (id == null) {
                throw new IllegalArgumentException("Question cannot be null");
            }
            return questionRepo.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
        }

        public Question addQuestion(Question question) {
            if (question == null) {
                throw new IllegalArgumentException("Question cannot be null");
            }else {
                return questionRepo.save(question);
            }
        }

        public Question updateQuestion(Long id, Question questionDetails) {
            Question question = questionRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            question.setQuestionTitle(questionDetails.getQuestionTitle());
            question.setOption1(questionDetails.getOption1());
            question.setOption2(questionDetails.getOption2());
            question.setOption3(questionDetails.getOption3());
            question.setOption4(questionDetails.getOption4());
            question.setRightAnswer(questionDetails.getRightAnswer());
            question.setDefficultylevel(questionDetails.getDefficultylevel());
            question.setCategory(questionDetails.getCategory());
            return questionRepo.save(question);
        }

        public void deleteQuestion(Long id) {
            questionRepo.deleteById(id);
        }

    public List<Question> addQuestions(Question question) {
        questionRepo.save(question); // Save the new question
        return questionRepo.findAll(); // Return all questions
    }


}
