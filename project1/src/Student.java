/*
 * A student can answer a question.
 * It is represented by a unique string which identifies the student.
 */

import java.util.Random;
import java.util.UUID;

public class Student {
    private Question question;
    private int[] answers;
    private String id;
    public boolean isSmart;

    public Student(Question question) {
        this.question = question;

        // Initialize id and isSmart
        isSmart = new Random().nextDouble() > 0.8 ? true : false; // 20% chance to be smart
        id = UUID.randomUUID().toString();
    }

    public void answerQuestion() {
        // TODO
    }

    public int[] getAnswers() {
        return answers;
    }

    public String getID() {
        return id;
    }
}
