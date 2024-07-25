package onlineexam;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Exam {
    private String[] questions = {
        "1. What is the capital of France?",
        "2. What is the result of 5 + 3?",
        "3. What is the square root of 16?",
        "4. Who wrote 'To Kill a Mockingbird'?",
        "5. What is the chemical symbol for water?"
    };

    private String[][] options = {
        {"a) Paris", "b) London", "c) Berlin", "d) Madrid"},
        {"a) 6", "b) 7", "c) 8", "d) 9"},
        {"a) 2", "b) 3", "c) 4", "d) 5"},
        {"a) Harper Lee", "b) J.K. Rowling", "c) Mark Twain", "d) Ernest Hemingway"},
        {"a) O", "b) H2O", "c) CO2", "d) NaCl"}
    };

    private char[] correctAnswers = {'a', 'c', 'c', 'a', 'b'};
    private char[] userAnswers = new char[questions.length];
    private int score = 0;
    private boolean examSubmitted = false;
    private Timer timer = new Timer();
    private static final int EXAM_DURATION = 30; // exam duration in seconds

    public void startExam(Scanner scanner) {
        score = 0;
        examSubmitted = false;
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                autoSubmitExam();
            }
        }, EXAM_DURATION * 1000);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (a/b/c/d): ");
            userAnswers[i] = scanner.next().charAt(0);

            if (userAnswers[i] == correctAnswers[i]) {
                score++;
            }

            if (examSubmitted) {
                return;
            }
        }

        timer.cancel();
        displayResult();
    }

    private void autoSubmitExam() {
        System.out.println("\nTime is up! Auto-submitting your exam...");
        examSubmitted = true;
        displayResult();
    }

    private void displayResult() {
        System.out.println("\nYou have completed the exam.");
        System.out.println("Your score is: " + score + "/" + questions.length);
    }
}
