package assignments.assignment10;

public class Question {
    protected double points;
    private static final int MIN_DIFFICULTY = 1;
    private static final int MAX_DIFFICULTY = 10;
    protected int difficulty;
    protected int answerSpace;
    protected String questionText;

    public Question(double points, int difficulty, int answerSpace, String questionText){
        if (difficulty < MIN_DIFFICULTY || difficulty > MAX_DIFFICULTY){
            throw new IllegalArgumentException("Difficulty out of range.");
        }
        this.points = points;
        this.difficulty = difficulty;
        this.answerSpace = answerSpace;
        this.questionText = questionText;
    }

    protected String printLines(){
        String str = "";
        for (int i = 0; i <= answerSpace; i++){
            str += "\n";
        }
        return str;
    }
    @Override
    public String toString(){
        return questionText + printLines();
    }
}   
