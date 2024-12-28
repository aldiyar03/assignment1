package models;

import java.util.ArrayList;

public class Student extends Person {
    private int studentID;
    private ArrayList<Integer> grades;

    public Student(String name, String surname, int age, boolean gender, int studentID) {
        super(name, surname, age, gender);
        this.studentID = studentID;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 1.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = sum / (double) grades.size();

        double gpa = 1.0 + (average / 100) * 3.0;
        return Math.round(gpa * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%s I am a student with ID %d.", super.toString(), studentID);
    }
}
