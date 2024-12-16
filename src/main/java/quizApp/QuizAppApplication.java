package quizApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuizAppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
	/*	QuizAppApplication q=new QuizAppApplication();
		q.run();
		q.run1();
	}
    int a=10;
	@Override
	public void run() {
		Thread t=new Thread();
		t.start();
		a++;
		System.out.println(a);
	}

	public void run1() {
		Thread t1=new Thread();
		t1.start();
		a++;
		System.out.println(a);
	}*/
	}
}
