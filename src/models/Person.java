package models;

public class Person {
    private String name;
    private String surname;
    protected int age;
    private boolean gender;

    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public boolean getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format("Hi, I am %s %s, a %d-year-old %s.", name, surname, age, gender ? "Male" : "Female");
    }
}
