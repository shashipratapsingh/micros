package quizApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import quizApp.Model.BackupQuestion;
import quizApp.Model.Question;
import quizApp.repository.BackupQuestionRepository;
import quizApp.repository.QuestionRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BackupService {

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private BackupQuestionRepository backupQuestionRepository;

    // Cron expression to run every minute
    @Scheduled(cron = "0 0/2 * * * ?")
    public void backupQuestions() {
        List<Question> questions = questionRepo.findAll();
        List<BackupQuestion> backupQuestions = questions.stream()
                .map(question -> new BackupQuestion(
                        question.getId(),
                        question.getQuestionTitle(),
                        question.getOption1(),
                        question.getOption2(),
                        question.getOption3(),
                        question.getOption4(),
                        question.getRightAnswer(),
                        question.getDefficultylevel(),
                        question.getCategory()))
                .collect(Collectors.toList());

        backupQuestionRepository.saveAll(backupQuestions);
    }
}
