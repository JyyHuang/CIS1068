package assignments.assignment06;

import java.io.*;
import java.util.Scanner;

/*Joey Huang
 * CIS1068
 * Section 003
 * 10/13/2023
 * Assignment 6. Game
 * 
 * This program takes a txt file as input and outputs a html file
 */
public class Webify {
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner userInput = new Scanner(System.in);
        System.out.println("Input the txt file:");
        String fileName = userInput.nextLine();

        File file = new File(fileName);
        Scanner readFile = new Scanner(file);
        
        PrintStream htmlFile = new PrintStream(new File(fileName.replace(".txt", ".html")));
        
        htmlFile.println("<html>");
        htmlFile.println("<body>");
        boolean firstList = true;
        boolean lastList = false;
        
        while(readFile.hasNextLine()){
            String line = readFile.nextLine();

            // check for last list element
            if (lastList && !line.startsWith("-")){
                htmlFile.println("</ul>");
                lastList = false;
                firstList = true;
            }
            // check for blank line
            if (line.equals("")){
                htmlFile.println("<p>");
            }
            // check if line starts and ends with _
            else if (line.startsWith("_") && line.endsWith("_")){
                String h1Element = line.replace("_", "");
                h1Element = checkHyperLink(h1Element);
                htmlFile.println("<h1>"+h1Element+"</h1>");
            } 
            // check if line starts with -
            else if (line.startsWith("-")){
                if (firstList == true){
                    htmlFile.println("<ul>");
                    firstList = false;
                    lastList = true;
                }
                String listElement = line.replace("-", "");
                listElement = checkHyperLink(listElement);
                htmlFile.println("<li>"+listElement+"</li>");
            }
            // extra credit: bold tag
            else if (line.startsWith("#") && line.endsWith("#")){
                String boldElement = line.replace("#", "");
                boldElement = checkHyperLink(boldElement);
                htmlFile.println("<b>"+boldElement+"</b>");
            }
            // anything else
            else{
                htmlFile.println(checkHyperLink(line) + "<br />");
            }
        }
        htmlFile.println("</body>");
        htmlFile.println("</html>");
        readFile.close();
        userInput.close();
    }

    public static String checkHyperLink(String line){
        line = line.strip();
        if ((line.startsWith("[[")) && (line.endsWith("]]"))){
            String url = line.substring(2, line.indexOf("]"));
            String title = line.substring(line.indexOf("]") + 2, line.length() - 2);
            return String.format("<a href=\"%s\">%s</a>", url, title);
        }
        return line;
    }
}
