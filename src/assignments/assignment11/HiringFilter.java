package assignments.assignment11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Joey Huang
 * CIS1068
 * Section 003
 * 12/06/2023
 * Assignment 11 Extra Credit. Hiring Recommender
 * 
 * 1. The criteria that I selected was gpa because it showed me the top applicants that did well in school, which may equate to doing well on the job.
 * 
 * 2. The type of candidates that we miss when we only look at gpa are ones who have know the most languages or go to the top schools. Other criteria that were not on the csv file could be previous experience or personal projects.
 */
public class HiringFilter {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("applicant_data.csv"));
        ArrayList<Applicant> applicants = new ArrayList<>();
        
        // reads first line
        scanner.nextLine();

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();

            String firstName = line.split(",")[1];
            String lastName = line.split(",")[0];
            // split line on comma only if its outside double quotes and add it to ArrayList
            double gpa = Double.parseDouble(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1)[8]);

            applicants.add(new Applicant(firstName, lastName, gpa));
        }

        // sorts in reverse order
        Collections.sort(applicants, Collections.reverseOrder());
        // Gets top 10
        applicants.subList(10, applicants.size()).clear();

        System.out.println("The top 10 applicants are:");
        for (int i = 0; i < 10; i ++){
            System.out.println(i+1 + ". " + applicants.get(i).getName());
        }
    }
}
