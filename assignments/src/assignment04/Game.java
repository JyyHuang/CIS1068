package assignment04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Game {

    /* Check the Winner
     * 
     * checkWinner(userMove, computerMove){
     *  result = false  (computer wins)
     *  if userMove = "condition"
     *      if computerMove = "condition" || "condition"
     *          result = true   (user wins)
     *  return result
     * }
     */
    public static boolean checkWinner(String user, String computer) {
        boolean result = false;
        if (user == "melltorp" && (computer == "utespelare" || computer == "olserod")) {
            result = true;
        } else if (user == "utespelare" && (computer == "knarrevik" || computer == "yngvar")) {
            result = true;
        } else if (user == "knarrevik" && (computer == "melltorp" || computer == "olserod")) {
            result = true;
        } else if (user == "olserod" && (computer == "yngvar" || computer == "utespelare")) {
            result = true;
        } else if (user == "yngvar" && (computer == "melltorp" || computer == "knarrevik")) {
            result = true;
        } else if (user == computer) {
            return result;
        }
        return result;
    }

    /*  Computer's Turn
     *  
     *  computerMove(choice) {
     *      return random choice
     *  }
     */
    public static String computerMove(String[] choices) {
        return choices[(new Random()).nextInt(choices.length)];
    }

    /*  User's Turn  
     *  
     * userMove(choices){
     *      Scanner for user input
     *      if input not in choices -> continue
     *      else return input
     *  }
     */
    public static String userMove(String[] choices) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a move:");
            String choice = scanner.nextLine();
            if (Arrays.asList(choices).contains(choice.toLowerCase())) {
                return choice;
            }
        }
    }

    /*  Play a Round
     *  
     *  playRound(){
     *      userMove()
     *      computerMove()
     *      checkWinner()
     *      prints computer move, user move, and winner
     *  }
     */
    public static boolean playRound(String[] choices) {
        String userChoice = userMove(choices);
        String computerChoice = computerMove(choices);
        
        System.out.println("Your Move: " + userChoice.substring(0, 1).toUpperCase() + userChoice.substring(1));
        System.out.println("Computer's Move: " + computerChoice.substring(0, 1).toUpperCase() + computerChoice.substring(1));

        boolean winner = checkWinner(userChoice, computerChoice);
        return winner;
    }

    /*  Print Rules
     *  
     *  rules(){
     *      print(rules)
     *  }
     */
    public static void rules() {

        System.out.println(
                "During each round, players choose a move, which may be either Olserod, Knarrevik, Utespelare, Yngvar, or Melltorp. \r\n\r\nThe rules are:\r\n"
                        +
                        "\r\n" +
                        "Melltorp beats Utespelare, Olserod\r\n" +
                        "Utespelare beats Knarrevik, Yngvar\r\n" +
                        "Knarrevik beats Melltorp, Olserod\r\n" +
                        "Olserod Beats Yngvar, Utespelare\r\n" +
                        "Yngvar beats Melltorp, Knarrevik\r\n" +
                        "\r\n" +
                        "The computer wins in the event of a tie.");
    }

    public static void main(String[] args) {
        rules();

        Scanner scanner = new Scanner(System.in);

        /* Ask For a Round
         * 
         * while true{
         *   Scanner
         *   if y -> playRound()
         *   if n -> break
         * }
         */
        String[] choices = { "olserod", "knarrevik", "utespelare", "yngvar", "melltorp" };

        int rounds = 0;
        int userWins = 0;
        int computerWins = 0;

        while (true) {
            System.out.println("Would you like to play a round?");

            String answer = scanner.nextLine();
            if (answer.equals("y")) {
                boolean thisRound = playRound(choices);
                if (thisRound == true) {
                    System.out.println("You won this round!");
                    userWins++;
                } else {
                    System.out.println("The computer won this round");
                    computerWins++;
                }
                rounds++;
            } else if (answer.equals("n")) {
                break;
            }
        }

        System.out.println("Rounds Played:" + rounds);
        System.out.println("User Wins:" + userWins);
        System.out.println("Computer Wins:" + computerWins);
    }
}
