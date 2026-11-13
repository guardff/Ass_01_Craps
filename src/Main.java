import java.util.Random;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    Random rnd = new Random();
    Scanner in = new Scanner(System.in);
    boolean keepPlaying = true;

    System.out.println("Welcome to the Craps Simulator!");

    while (keepPlaying) {
        System.out.println("\n--- New Game Commencing ---");

        // Initial Roll (Using the lecture formula)
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int initialSum = die1 + die2;

        System.out.printf("Initial Roll -> Die 1: %d, Die 2: %d | Sum: %d\n", die1, die2, initialSum);

        // Case i: Crapping out
        if (initialSum == 2 || initialSum == 3 || initialSum == 12) {
            System.out.println("Result: Crapped out! You lose.");
        }
        // Case ii: Natural win
        else if (initialSum == 7 || initialSum == 11) {
            System.out.println("Result: Natural! You win!");
        }
        // Case iii: Establish the point
        else {
            int point = initialSum;
            System.out.printf("The point is now established as: %d\n", point);

            boolean pointPhaseActive = true;

            while (pointPhaseActive) {
                System.out.println("Status: Trying for point...");

                // Subsequent rolls
                int subDie1 = rnd.nextInt(6) + 1;
                int subDie2 = rnd.nextInt(6) + 1;
                int subSum = subDie1 + subDie2;

                System.out.printf("Roll -> Die 1: %d, Die 2: %d | Sum: %d\n", subDie1, subDie2, subSum);

                if (subSum == point) {
                    System.out.println("Status: Made point and won!");
                    pointPhaseActive = false; // Ends the rolling phase
                } else if (subSum == 7) {
                    System.out.println("Status: Got a seven and lost.");
                    pointPhaseActive = false; // Ends the rolling phase
                }
            }
        }

        // Prompt to play again
        System.out.print("\nDo you want to play another game? (yes/no): ");
        String userResponse = in.nextLine().trim().toLowerCase();

        if (!userResponse.equals("yes") && !userResponse.equals("y")) {
            keepPlaying = false;
        }
    }

    System.out.println("Thank you for playing Craps!");
    in.close();
}
}