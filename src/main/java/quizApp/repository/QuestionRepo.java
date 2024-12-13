package quizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quizApp.Model.Question;

public interface QuestionRepo extends JpaRepository<Question,Long> {
}
