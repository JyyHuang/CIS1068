package assignments.assignment10;

import java.util.Arrays;

public class MultipleChoiceQuestion extends ObjectiveQuestion {
    protected String[] possibleAnswers;

    public MultipleChoiceQuestion(double points, int difficulty, int answerSpace, String questionText, String[] possibleAnswers, String correctAnswer){
        if (answerSpace != 1){
            throw new IllegalArgumentException("Answer Space is only one!");
        }
        if (!Arrays.asList(possibleAnswers).contains(correctAnswer)){
            throw new IllegalArgumentException("Correct answer needs to be in possible Answers!");
        }
    }
}
