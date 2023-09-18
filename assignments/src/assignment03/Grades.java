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

    // Homework score
    public static double homeWorkGrade(int weight, int numberOfAssignments, double avg, int lateDays, int labs) {
        // homework 10 points
        // lab 4 points
        //num hw and labs is ==
        //more late days than half than reduce 10% 
        // no late days then 5 points extra credit
        // cant get more than 100% of grade
        double hwGrade;

        if (numberOfAssignments <= 0) {
            return weight;
        } else if (avg < 0) {
            avg = 0;
        } else if (avg > 10) {
            avg = 10;
        }

        int homeworkTotal = (numberOfAssignments * 10) + (((labs*4/numberOfAssignments))*10);
        hwGrade = (avg * numberOfAssignments);
        
        if (lateDays > (numberOfAssignments / 2))
        {
            hwGrade = hwGrade * .90;
        } else if (lateDays == 0 && hwGrade < numberOfAssignments * 10) {
            hwGrade = hwGrade + 5;
        }
        
        double total = hwGrade + labs * 4;
        System.out.println(String.format("Total points = %s / %s", total,homeworkTotal));
        double weightedGrade = (total / homeworkTotal) * weight;
        return weightedGrade;
    }        

    public static void main(String[] args) {
        // Get weights
        Scanner scanner = new Scanner(System.in);
        System.out.println("Homework weight? ");
        int homeWorkWeight = scanner.nextInt();

        System.out.println("Exam 1 weight? ");

        int exam1Weight = scanner.nextInt();
        int exam2Weight = 100 - homeWorkWeight - exam1Weight;
        System.out.println(String.format("Using weights of %s %s %s", homeWorkWeight, exam1Weight, exam2Weight));

        System.out.println("Homework:");
        System.out.println("Number of assignments?");
        int assignmentNumber = scanner.nextInt();

        System.out.println("Average Homework grade?");
        double avgGrade = scanner.nextDouble();

        System.out.println("Number of late days used?");
        int lateDays = scanner.nextInt();

        System.out.println("Labs attended?");
        int numLabs = scanner.nextInt();

        double weightedHomework = homeWorkGrade(homeWorkWeight, assignmentNumber, avgGrade, lateDays, numLabs);
        System.out.println(String.format("Weighted score = %.2f",weightedHomework));






        scanner.close();


    }
}
