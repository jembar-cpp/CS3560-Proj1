/*
 * Main driver for the simulation.
 */

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("TODO");

        Question q = new Question(false, new boolean[] {false});
        Student s = new Student(q);
        System.out.println("\n" + s.getID());
    }
}
