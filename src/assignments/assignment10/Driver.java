package assignments.assignment10;

public class Driver {

    public static Test createTest(){
        ObjectiveQuestion q1 = new ObjectiveQuestion(10, 5, 4, "What is 2 + 3?", "5");
        FillInTheBlankQuestion q2 = new FillInTheBlankQuestion(10, 2, 1, "was the 16th US President.", "Abraham Lincoln");

        String[] possibleAnswers = {"Peter Griffin", "Scooby Doo", "Spongebob Sqaurepants", "Eric Cartman"};
        MultipleChoiceQuestion q3 = new MultipleChoiceQuestion(20, 6, 1, "Who lives in a pineapple under the tree?", possibleAnswers, "Spongebob Sqaurepants");

        ObjectiveQuestion[] testQuestions = {q1,q2,q3};
        
        Test test = new Test(testQuestions);

        return test;
    }

    public static void main(String[] args) {
        Test test = createTest();
        System.out.println(test.toString());
        System.out.println(test.toAnswerString());
    }
}
