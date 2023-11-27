package assignments.assignment10;

public class FillInTheBlankQuestion extends ObjectiveQuestion {

    public FillInTheBlankQuestion(double points, int difficulty, int answerSpace, String questionText, String correctAnswer){
        super(points, difficulty, answerSpace, questionText, correctAnswer);
    }

    @Override
    public String toString(){
        return "______ " + questionText;
    }

    @Override
    public String getAnswer(){
        return toString() + "\n" + "Answer: " + "___" + correctAnswer +"___" + questionText;
    }
}
