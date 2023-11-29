package assignments.assignment10;

import java.io.FileNotFoundException;

public class Driver {

    public static Test createTest(){
        ObjectiveQuestion q1 = new ObjectiveQuestion(10, 5, 4, "What is 2 + 3?", "5");
        FillInTheBlankQuestion q2 = new FillInTheBlankQuestion(10, 2, 3, "was the 16th US President.", "Abraham Lincoln");

        String[] possibleAnswers = {"Peter Griffin", "Scooby Doo", "Spongebob Sqaurepants", "Eric Cartman"};
        MultipleChoiceQuestion q3 = new MultipleChoiceQuestion(20, 6, 1, "Who lives in a pineapple under the tree?", possibleAnswers, "Spongebob Sqaurepants");

        ObjectiveQuestion[] testQuestions = {q1,q2,q3};
        
        Test test = new Test(testQuestions);

        return test;
    }

    public static void main(String[] args) throws FileNotFoundException{
        Test test = createTest();

        // can void toString but kept for reading sake
        System.out.println(test.toString());
        System.out.println(test.answerKey());

        test.sendToFileQuestions("questions.txt");
        test.sendToFileAnswers("answers.txt");
    }
}
