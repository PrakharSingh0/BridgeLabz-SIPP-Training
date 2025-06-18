import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        return choices[new Random().nextInt(3)];
    }

    public static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) return "Draw";
        if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock"))) {
            return "User Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userWins = 0, computerWins = 0, draws = 0;

        System.out.print("Enter number of games: ");
        int games = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();
            String computerChoice = getComputerChoice();

            System.out.println("Computer chose: " + computerChoice);
            String result = determineWinner(userChoice, computerChoice);
            System.out.println("Result: " + result);

            if (result.equals("User Wins")) userWins++;
            else if (result.equals("Computer Wins")) computerWins++;
            else draws++;
        }

        System.out.println("\nFinal Stats:");
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Draws: " + draws);

        scanner.close();
    }
}