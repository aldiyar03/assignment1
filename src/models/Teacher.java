package models;

public class Teacher extends Person {
    private String subject;
    private int yearsOfExperience;
    private int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(double percentage) {
        salary += salary * percentage / 100;
    }

    public int getSalary() {
        return salary;
    }

    public String getSubject() {
        return subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return String.format("%s I teach %s and have %d years of experience. My salary is %d.",
                super.toString(), subject, yearsOfExperience, salary);
    }
}
