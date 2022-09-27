/*
 * A student can answer a question.
 * It is represented by a unique string which identifies the student.
 */

import java.util.Random;
import java.util.UUID;
import java.util.ArrayList;

public class Student {
    private Question question;
    private ArrayList<Integer> choices = new ArrayList<Integer>();
    private String id;
    public boolean isSmart;

    public Student(Question question) {
        this.question = question;

        // Initialize id and isSmart
        isSmart = new Random().nextDouble() > 0.8 ? true : false; // 20% chance to be smart
        id = UUID.randomUUID().toString();
    }

    public void answerQuestion() {
        boolean answers[] = question.getAnswers();
        int numAnswers = question.getNumAnswers();
        Random r = new Random();

        // Likeliness to answer correctly
        double num = Math.abs(r.nextGaussian()); // normally distributed value
        if(isSmart) {
            num -= 0.5; // student is likelier to answer correctly
        }

        // Only 1 correct answer
        if(!question.isMultiple()) {
            // Answer correctly
            if(num < 0.9) {
                for(int i = 0; i < numAnswers; i++) {
                    if(answers[i]) {
                        choices.add(i);
                    }
                }
            }

            // Answer randomly
            else if (num < 1.7) {
                choices.add(r.nextInt(numAnswers));
            }

            // else: student fell asleep, don't answer
        }

        // Multiple correct answers are hard
        else {
            for(int i = 0; i < numAnswers; i++) {
                double rand = Math.abs(r.nextGaussian());
                if(isSmart) {
                    rand -= 0.5; // student is likelier to answer correctly
                }

                if(answers[i]) {
                    // Answer is correct
                    if(rand < 1) {
                        choices.add(i); // answer correctly
                    }
                }
                else {
                    // Answer is incorrect
                    if(rand > 1.5) {
                        choices.add(i); // answer incorrectly
                    }
                }
            }
        }
    }

    public ArrayList<Integer> getChoices() {
        return choices;
    }

    public String getID() {
        return id;
    }
}
