package assignments.assignment04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/*Joey Huang
 * CIS1068
 * Section 003
 * 09/28/2023
 * Assignment 3. Game
 * 
 * This program is a game between the user and computer. After user enters n, the game summary will be printed.
 */
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
        if (user.equals("melltorp") && (computer.equals("utespelare") || computer.equals("olserod"))) {
            result = true;
        } else if (user.equals("utespelare") && (computer.equals("knarrevik") || computer.equals("yngvar"))) {
            result = true;
        } else if (user.equals("knarrevik") && (computer.equals("melltorp") || computer.equals("olserod"))) {
            result = true;
        } else if (user.equals("olserod") && (computer.equals("yngvar") || computer.equals("utespelare"))) {
            result = true;
        } else if (user.equals("yngvar") && (computer.equals("melltorp") || computer.equals("knarrevik"))) {
            result = true;
        } else if (user.equals(computer)) {
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
    public static String userMove(String[] choices, Scanner scanner) {

        while (true) {
            System.out.println("Enter a move:");
            String choice = scanner.nextLine();
            if (Arrays.asList(choices).contains(choice.toLowerCase())) {
                return choice.toLowerCase();
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
    public static boolean playRound(String[] choices, Scanner scanner) {
        String userChoice = userMove(choices, scanner);
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

    /* Game Summary
     * 
     * print rounds, user wins, and computer wins
     */
    public static void gameSummary(int rounds, int userWins, int computerWins){
        System.out.println("Rounds Played:" + rounds);
        System.out.println("User Wins:" + userWins);
        System.out.println("Computer Wins:" + computerWins);
    }

    /* Ask to Play
     * 
     * while true {
     *  if y -> playRound
     *     if round == true -> user wins
     *      else -> computer wins
     *  if n -> break
     * }
     */
    public static void askUser(Scanner scanner, String[] choices, int rounds, int userWins, int computerWins){
        while (true) {
            System.out.println("Would you like to play a round?");
            String answer = scanner.nextLine();
            
            if (answer.equals("y")) {
                boolean thisRound = playRound(choices, scanner);
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
        gameSummary(rounds, userWins, computerWins);
    }

    /* main
     * 
     * print rules
     * initialize variables,array, and scanner
     * ask user if they want to play
     * 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rules();

        String[] choices = { "olserod", "knarrevik", "utespelare", "yngvar", "melltorp" };

        int rounds = 0;
        int userWins = 0;
        int computerWins = 0;

        askUser(scanner, choices, rounds, userWins, computerWins);
    }
}
