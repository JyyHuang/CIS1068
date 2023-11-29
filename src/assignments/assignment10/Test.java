package assignments.assignment10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test {
    protected ObjectiveQuestion[] questions;
    protected double totalPoints;

    public Test(ObjectiveQuestion[] questions){
        this.questions = questions;
        for (int i = 0; i < questions.length; i++){
            this.totalPoints += questions[i].points;
        }
    }

    @Override
    public String toString(){
        String testQuestions = "";
        testQuestions += "Total Points: " + totalPoints + "\n";
        for (int i = 0; i < questions.length; i++){
            testQuestions += questions[i].toString();
        }
        return testQuestions;
    }

    public String answerKey(){
        String testAnswers = "";
        for (int i = 0; i < questions.length; i++){
            testAnswers += questions[i].toAnswerString();
        }
        return testAnswers;
    }

    public void sendToFileQuestions(String filename) throws FileNotFoundException{
        PrintStream file = new PrintStream(new File(filename));
        file.println(toString());
    }

    public void sendToFileAnswers(String filename) throws FileNotFoundException {
        PrintStream file = new PrintStream(new File(filename));
        file.println(answerKey());
    }
}
