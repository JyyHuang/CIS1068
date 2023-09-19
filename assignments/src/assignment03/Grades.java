/*Joey Huang
 * CIS1068
 * Section 003
 * 09/19/2023
 * Assignment 3. Grade Calculator
 * 
 * This program asks the user for inputs of grade weights, assignments, and exam scores to calculate the final grade of the semester
 */

import java.util.Scanner;

public class Grades {

    // Exam Score
    public static double examGrade(int weight, int score, int curve) {

        double examGrade = score + curve;

        // Checks edge cases for negative and if greater than total
        if (score < 0) {
            examGrade = 0;
        } else if (score > 100 || examGrade > 100) {
            examGrade = 100;
        }

        double weightedGrade = (examGrade / 100) * weight;
        System.out.println(String.format("Total points = %s / %s", examGrade, 100));
;       
        return weightedGrade;
    }

    // Homework score
    public static double homeWorkGrade(int weight, int numberOfAssignments, double avg, int lateDays, int labs) {
        
        // Checks edge cases if number of assignments is 0 or negative
        // Also caps the max points and checks if avg is negative
        if (numberOfAssignments <= 0) {
            return weight;
        } else if (avg < 0) {
            avg = 0;
        } else if (avg > 10) {
            avg = 10;
        }


        int assignmentGrade = numberOfAssignments * 10;

        // Assignment grade + lab grade
        int homeworkTotal = (assignmentGrade) + ((numberOfAssignments) * 4);

        double hwGrade = (avg * numberOfAssignments);

        // Checks late day requirements
        if (lateDays > (numberOfAssignments / 2)) {
            hwGrade = hwGrade * .90;
        } else if (lateDays == 0 && (hwGrade < assignmentGrade)) {
            if ((hwGrade + 5) > assignmentGrade) {
                hwGrade = assignmentGrade;
            } else {
                hwGrade = hwGrade + 5;
            }
        }

        double total = hwGrade + labs * 4;
        double weightedGrade = (total / homeworkTotal) * weight;
        System.out.println(String.format("Total points = %s / %s", total, homeworkTotal));
        return weightedGrade;
    }
            
    public static void printWeightedScore(double score) {
        System.out.println(String.format("Weighted score = %.2f", score));
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

        // Weighted Homework
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
        printWeightedScore(weightedHomework);

        //Exam 1
        System.out.println("Exam 1:");
        System.out.println("Score?");
        int exam1Score = scanner.nextInt();

        System.out.println("Curve?");
        int exam1Curve = scanner.nextInt();

        double weightedExam1 = examGrade(exam1Weight, exam1Score, exam1Curve);
        printWeightedScore(weightedExam1);

        //Exam 2
        System.out.println("Exam 2:");
        System.out.println("Score?");
        int exam2Score = scanner.nextInt();
        System.out.println("Curve?");
        int exam2Curve = scanner.nextInt();
        double weightedExam2 = examGrade(exam2Weight, exam2Score, exam2Curve);
        printWeightedScore(weightedExam2);

        double courseGrade = weightedHomework + weightedExam1 + weightedExam2;
        System.out.print(String.format("Course grade = %.2f", courseGrade));

        scanner.close();
    }
}
