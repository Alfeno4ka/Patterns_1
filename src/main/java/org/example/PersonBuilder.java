package org.example;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;

    public PersonBuilder(String lastName, Integer age, String city) {
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public PersonBuilder() {
    }

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (firstName == null || firstName.length() < 1 || lastName == null || lastName.length() < 1) {
            throw new IllegalStateException("Имя и фамилия должны быть заданы и должны содержать не менее 1 символа");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательной величиной");
        }

        return new Person(firstName, lastName, age, city);
    }

}
