package org.example;

public class Person {
    private final String firstName;
    private final String lastName;
    private Integer age;
    private String city;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = null;
        this.city = null;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = null;
    }

    public Person(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasCity() {
        return city != null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (age == null) {
            age = 1;
        } else {
            age++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');

        if (hasAge()) {
            sb.append(", age=").append(age);
        } else {
            sb.append(", age=unknown");
        }

        if (hasCity()) {
            sb.append(", city='").append(city).append('\'');
        } else {
            sb.append(", city=unknown");
        }

        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hashCode = firstName.hashCode();
        hashCode = 31 * hashCode + lastName.hashCode();
        if (age != null) {
            hashCode = 31 * hashCode + age.hashCode();
        }
        if (city != null) {
            hashCode = 31 * hashCode + city.hashCode();
        }
        return hashCode;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder(lastName, 0, city);
    }
}
