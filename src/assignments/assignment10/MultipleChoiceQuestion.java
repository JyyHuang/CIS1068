package assignments.assignment10;

import java.util.Arrays;

public class MultipleChoiceQuestion extends ObjectiveQuestion {
    protected String[] possibleAnswers;

    public MultipleChoiceQuestion(double points, int difficulty, int answerSpace, String questionText, String[] possibleAnswers, String correctAnswer){
        super(points, difficulty, answerSpace, questionText, correctAnswer);
        if (answerSpace != 1){
            throw new IllegalArgumentException("Answer Space is only one!");
        }
        if (!Arrays.asList(possibleAnswers).contains(correctAnswer)){
            throw new IllegalArgumentException("Correct answer needs to be in possible Answers!");
        }
        this.possibleAnswers = possibleAnswers;
    }

    @Override
    public String toString(){
        String question = questionText + "\n\n";
        for (int i = 1; i <= possibleAnswers.length; i++){
            question += i + ". " + possibleAnswers[i-1] + "\n";
        }
        return question;
    }

    @Override
    public String toAnswerString(){
        return toString().replace(correctAnswer, "**** "+ correctAnswer +" ****");
    }
}
