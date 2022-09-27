/*
 * Main driver for the simulation.
 */

import java.util.Random;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        int numStudents = r.nextInt(51) + 25; // random number of students (25 - 75)
        int numAnswers = r.nextInt(4) + 5;    // number of answers (5 - 8)
        int numCorrect = 0;                   // number of correct answers
        
        // Populate correct answers randomly
        boolean correct[] = new boolean[numAnswers];
        for(int i = 0; i < numAnswers; i++) {
            if(Math.abs(r.nextGaussian()) > 1) {
                correct[i] = true;
                numCorrect++;
            }
            else {
                correct[i] = false;
            }
        }
        if(numCorrect == 0) {
            // Failed to generate at least 1 correct answer
            numCorrect = 1;
            correct[r.nextInt(numAnswers+1)] = true;
        }
        System.out.println(numStudents + ", "+numAnswers+", "+numCorrect+", "+Arrays.toString(correct));
        boolean isMultiple = numCorrect > 1;

        Question q = new Question(isMultiple, correct);
        for(int i = 0; i < 50; i++) {
        Student s = new Student(q);
        s.answerQuestion();
        System.out.println(Arrays.toString(s.getChoices().toArray()));}
    }
}
