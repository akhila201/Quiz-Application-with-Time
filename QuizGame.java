import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {

    // Quiz Questions, Options, and Correct Answers
    static String[] questions = {
        "What is the capital of France?",
        "What is 2 + 2?",
        "Who wrote 'Romeo and Juliet'?",
        "What is the largest planet in our solar system?",
        "What is the square root of 16?"
    };

    static String[][] options = {
        {"1. Paris", "2. London", "3. Berlin", "4. Madrid"},
        {"1. 3", "2. 4", "3. 5", "4. 6"},
        {"1. William Shakespeare", "2. Charles Dickens", "3. Mark Twain", "4. J.K. Rowling"},
        {"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"},
        {"1. 2", "2. 3", "3. 4", "4. 5"}
    };

    static int[] correctAnswers = {1, 2, 1, 3, 3};  // Correct answers (indices start from 1)

    static int score = 0;
    static int questionIndex = 0;

    // Timer for each question
    static Timer timer = new Timer();

    // Function to start the quiz
    public static void startQuiz() {
        Scanner scanner = new Scanner(System.in);
for (questionIndex = 0; questionIndex < questions.length; questionIndex++) {
            System.out.println("\nQuestion " + (questionIndex + 1) + ":");
            System.out.println(questions[questionIndex]);
            
            // Display options
            for (String option : options[questionIndex]) {
                System.out.println(option);
            }

            // Timer Task
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    nextQuestion();
                }
            };
            // Start timer for 30 seconds
            timer.schedule(task, 30000);

            // Get the user's answer
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            // Cancel the timer once the user answers
            task.cancel();

            // Check if the answer is correct
            if (userAnswer == correctAnswers[questionIndex]) {
                score++;
   }

            // Move to next question
            nextQuestion();
        }
        displayResults();
        scanner.close();
    }

    // Function to move to the next question
    public static void nextQuestion() {
        // Print a message to separate questions
        if (questionIndex < questions.length - 1) {
            System.out.println("\nNext question...\n");
        }
    }

    // Function to display final results
    public static void displayResults() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your final score: " + score + "/" + questions.length);
        System.out.println("Correct Answers:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            System.out.println("Correct Answer: " + options[i][correctAnswers[i] - 1]);
        }
    }

    public static void main(String[] args) {
        // Start the quiz
        startQuiz();
    }
}
