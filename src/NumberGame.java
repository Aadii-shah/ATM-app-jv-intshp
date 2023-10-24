import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner =new Scanner(System.in);
        int min = 0;
        int max = 100;
        int maxAttempts = 5;
        int roundWon = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        while (playAgain){
            int randomNumber = random.nextInt(max - min + 1) + min; // generate random number
            int attempts = 0;

            while (attempts < maxAttempts){
                System.out.println("Guess the number: ");
                int userGuess = scanner.nextInt();
                attempts++;


                if (userGuess == randomNumber){
                    System.out.println("You've guessed the correct number:" + userGuess);
                    roundWon++;
                    totalAttempts += attempts;
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("You've guessed the high. Try again !!!!");
                } else {
                    System.out.println("You've guessed the low. Try again !!!!");
                }
            }

            if (attempts >= maxAttempts){
                System.out.println("You've ran out of attempts. The correct number is:" + randomNumber);
            }
            System.out.println("Do you want to play again ? (yes/no):");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        System.out.println("Game over!!!");
        System.out.println("Round won:  " + roundWon);
        System.out.println("Total attempts  "+ totalAttempts);





    }
}