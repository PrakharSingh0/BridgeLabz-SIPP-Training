public class QuizGrader {

    // Sample questions, correct answers, and student answers
    static String[] questions = {
        "1. What is the capital of France?",
        "2. What is 2 + 2?",
        "3. What color do you get when you mix red and white?",
        "4. Who wrote 'Romeo and Juliet'?",
        "5. What is the largest planet in our solar system?",
        "6. What is the boiling point of water in Celsius?",
        "7. What is the chemical symbol for gold?",
        "8. Who painted the Mona Lisa?",
        "9. What is the fastest land animal?",
        "10. What is the square root of 81?"
    };

    static String[] correctAnswers = {
        "Paris",
        "4",
        "Pink",
        "Shakespeare",
        "Jupiter",
        "100",
        "Au",
        "Da Vinci",
        "Cheetah",
        "9"
    };

    static String[] studentAnswers = {
        "paris",        // correct
        "4",            // correct
        "pink",         // correct
        "shakespear",   // incorrect (spelling)
        "Saturn",       // incorrect
        "100",          // correct
        "AU",           // correct (case-insensitive)
        "Da vinci",     // correct (case-insensitive)
        "cheetah",      // correct (case-insensitive)
        "eight"         // incorrect
    };

    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                System.out.println(questions[i]);
                System.out.println("Your answer: " + student[i]);
                System.out.println("Feedback: Correct\n");
                score++;
            } else {
                System.out.println(questions[i]);
                System.out.println("Your answer: " + student[i]);
                System.out.println("Correct answer: " + correct[i]);
                System.out.println("Feedback: Incorrect\n");
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int score = calculateScore(correctAnswers, studentAnswers);
        System.out.println("Total Score: " + score + " out of " + correctAnswers.length);
    }
}
