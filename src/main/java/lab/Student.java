package lab;

import java.lang.reflect.Array;
//imports ALL java utilities
import java.util.*;

public class Student {

    private String firstName;
    private String lastName;

    Double[] testScores;
    List<Double> examScores;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
        //Returns a fixed list, immutable
        this.examScores = Arrays.asList(testScores);

    }

    //object state will be mutated via this method
    //make a method that just returns the size of arraylist of examScores
    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    //make a method that returns a string of all exams taken
    public String getExamScores() {
        /*Create a container that holds a string that represents exam scores
         Create a for loop that says as long as the starting index position is less than the amount of exam scores,
        increment by 1. Print the string initialized above and lay out the format
        Reassign the string variable to equal the string message along with getting each new exam score
        print the string container that has been reassigned
         */
        String score = "Exam Scores: \n";

        for (int i = 0; i < examScores.size(); i++) {
            score = score + "Exam # " + (i + 1) + " -> ";
            score = score + examScores.get(i) + "\n";
        }
        return score;
    }
    //Create a method that allows you to add a new exam score
    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }
    //Create a method that allows you to set a new exam score
    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber, newScore);
    }
    //Create a method that calculates the average exam score
    public double getAverageExamScore() {
        /*
        Initialize a container that holds double types and set it equal to 0.
        Make a for loop that says as long as the index position is less than the amount of scores,
        increment by 1. Reassign the double container "total" to equal the exam scores plus whatever the total was before
        Divide the total by the amount of scores to find the average
         */
        double total = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            total = total + examScores.get(i);
        }
        return total / examScores.size();
    }

    @Override
    public String toString() {
        return String.format("Student Name: %s %s\n" + "Average Score: %.1f\n" + "Exam Scores: %s", firstName, lastName, getAverageExamScore(), getExamScores());
    }
}
