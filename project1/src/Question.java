/*
 * A Question is a multiple-choice question which can have one or more correct answers.
 * Either multiple answers can be selected, or only one answer can be selected.
 */

public class Question {
    private boolean multiple;   // whether multiple answers can be selected or not
    private boolean[] answers;  // a boolean array of the answers and if they are correct
    private int numAnswers;

    public Question(boolean multiple, boolean[] answers) {
        this.multiple = multiple;
        this.answers = answers;
        numAnswers = answers.length;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public boolean[] getAnswers() {
        return answers;
    }

    public int getNumAnswers() {
        return numAnswers;
    }
}
