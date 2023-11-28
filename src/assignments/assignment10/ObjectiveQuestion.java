package assignments.assignment10;

public class ObjectiveQuestion extends Question {
    protected String correctAnswer;

    public ObjectiveQuestion(double points, int difficulty, int answerSpace, String questionText, String correctAnswer){
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }

    public String toAnswerString(){
        return questionText + "\n" + "Answer: " + correctAnswer + "\n";
    }
}
