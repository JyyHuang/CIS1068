package assignments.assignment10;

public class Test {
    private ObjectiveQuestion[] questions;
    private double totalPoints;
    public Test(ObjectiveQuestion[] questions){
        this.questions = questions;
        for (int i = 0; i < questions.length; i++){
            this.totalPoints += questions[i].points;
        }
    }

    @Override
    public String toString(){
        String testQuestions = "";
        for (int i = 0; i < questions.length; i++){
            testQuestions += questions[i].toString();
        }
        return testQuestions;
    }

    public String toAnswerString(){
        String testAnswers = "";
        for (int i = 0; i < questions.length; i++){
            testAnswers += questions[i].toAnswerString();
        }
        return testAnswers;
    }

}
