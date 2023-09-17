/*Joey Huang
 * CIS1068
 * Section 003
 * 09/17/2023
 * Assignment 3. Grade Calculator
 * 
 * 
 */

import java.util.Scanner;

public class Grades {
    public static int[] gradeWeights() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Homeowork weight? ");
        int homeWorkWeight = scanner.nextInt();
        System.out.println("Exam 1 weight? ");
        int exam1Weight = scanner.nextInt();
        int exam2Weight = 100 - homeWorkWeight - exam1Weight;
        System.out.print(String.format("Using weights of %s %s %s", homeWorkWeight, exam1Weight, exam2Weight));
        scanner.close();
        int[] weights = {homeWorkWeight, exam1Weight, exam2Weight}
        return weights;
    }

    // Homework score
    public static void homeWorkScore() {
    
    }        
    public static void main(String[] args) {
        gradeWeights();
    }
}
