/*
 * Outputs the result of the simulation.
 */

import java.util.ArrayList;

public class VotingService {
    public static void outputResults(Student[] students, Question question) {
        // Outputs results from array of students which have answered the question

        boolean answers[] = question.getAnswers();
        int numAnswers = question.getNumAnswers();
        int answerStats[] = new int[numAnswers];
        int numNotAnswered = 0;

        // Get statistics
        ArrayList<Integer> choices = new ArrayList<Integer>();
        for(Student s : students) {
            choices = s.getChoices();

            if(choices.size() == 0) {
                // Student didn't answer
                numNotAnswered++;
                continue;
            }

            for(int i : choices) {
                answerStats[i]++;
            }
        }

        // Print statistics
        System.out.println("Question results:");
        System.out.println("Number of students: " + students.length);
        System.out.println("Number of students who answered: " + (students.length - numNotAnswered) + '\n');

        // Print question and answers
        System.out.println("Question: Which of the following is a correct answer?\n");

        for(int i = 0; i < numAnswers; i++) {
            System.out.print((char)('A' + i));
            if(answers[i]) {
                System.out.print(" (correct answer)   : ");
            }
            else {
                System.out.print(" (incorrect answer) : ");
            }
            System.out.println(answerStats[i]);
        }
    }
}
