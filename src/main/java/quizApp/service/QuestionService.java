package quizApp.service;


import quizApp.Model.Question;;

import java.util.List;

public interface QuestionService {
    public Question addQuestion(Question question);
    public List<Question> getAllQuestions();
    public Question getQuestionById(Long id);
    public Question updateQuestion(Long id, Question questionDetails);
    public void deleteQuestion(Long id);

}
