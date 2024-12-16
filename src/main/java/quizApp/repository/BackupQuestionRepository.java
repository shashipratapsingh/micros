package quizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quizApp.Model.BackupQuestion;

@Repository
public interface BackupQuestionRepository extends JpaRepository<BackupQuestion, Long> {
}
