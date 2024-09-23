package org.example;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setFirstName("Анна")
                .setLastName("Вольф")
                .setAge(31)
                .setCity("Сидней")
                .build();

        System.out.println(mom);

        mom.happyBirthday();
        System.out.println("Возраст после дня рождения: " + mom.getAge());

        Person son = mom.newChildBuilder()
                .setFirstName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            Person test = new PersonBuilder()
                    .setFirstName("Анна")
                    .setLastName("Николаева")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}