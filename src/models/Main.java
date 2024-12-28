package models;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School();

        try {
            Scanner studentScanner = new Scanner(new File("src/students.txt"));
            while (studentScanner.hasNextLine()) {
                String[] data = studentScanner.nextLine().split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = data[3].equalsIgnoreCase("Male");
                Student student = new Student(name, surname, age, gender, school.getMembers().size() + 1);
                for (int i = 4; i < data.length; i++) {
                    student.addGrade(Integer.parseInt(data[i]));
                }
                school.addMember(student);
            }
            studentScanner.close();

            Scanner teacherScanner = new Scanner(new File("src/teachers.txt"));
            while (teacherScanner.hasNextLine()) {
                String[] data = teacherScanner.nextLine().split(" ");
                String name = data[0];
                String surname = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = data[3].equalsIgnoreCase("Male");
                String subject = data[4];
                int yearsOfExperience = Integer.parseInt(data[5]);
                int salary = Integer.parseInt(data[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                school.addMember(teacher);
            }
            teacherScanner.close();
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файлов: " + e.getMessage());
        }

        school.getMembers().stream()
                .filter(m -> m instanceof Student)
                .forEach(System.out::println);
        System.out.println();

        school.getMembers().stream()
                .filter(m -> m instanceof Teacher)
                .forEach(System.out::println);
        System.out.println();

        school.getMembers().stream()
                .filter(m -> m instanceof Student)
                .map(m -> (Student) m)
                .forEach(s -> System.out.printf("%s %s GPA: %.2f%n", s.getName(), s.getSurname(), s.calculateGPA()));
        System.out.println();

        school.getMembers().stream()
                .filter(m -> m instanceof Teacher)
                .map(m -> (Teacher) m)
                .filter(t -> t.getYearsOfExperience() > 10)
                .forEach(t -> {
                    System.out.printf("Teacher %s %s (Subject: %s, Experience: %d years) before raise: Salary = %d%n",
                            t.getName(), t.getSurname(), t.getSubject(), t.getYearsOfExperience(), t.getSalary());
                    t.giveRaise(10);
                    System.out.printf("Teacher %s %s after raise: Salary = %d%n%n", t.getName(), t.getSurname(), t.getSalary());
                });
    }
}
