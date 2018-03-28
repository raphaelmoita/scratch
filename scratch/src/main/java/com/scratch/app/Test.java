package com.scratch.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

class Test {

    private static BiConsumer<String, Map<Integer, Double>> results = (gender, info) ->
            info.forEach((age, weight) -> System.out.println(String.format("Gender: %s - Age: %s - Average weight: %.2f", gender, age, weight)));

    public static void main(String... args) {
        final List<Person> users = Arrays.asList(
                new Person.Builder().gender("M").age(20).weight(88).build(),
                new Person("F", 20, 55),
                new Person("M", 20, 48),
                new Person("M", 20, 68),
                new Person("M", 20, 77),
                new Person("F", 22, 102),
                new Person("F", 20, 88),
                new Person("F", 20, 55),
                new Person("M", 23, 48),
                new Person("F", 23, 68),
                new Person("M", 23, 77),
                new Person("M", 20, 102));

        final Map<String, Map<Integer, Double>> data = users.stream().collect(
                Collectors.groupingBy(Person::getGender,
                    Collectors.groupingBy(Person::getAge,
                        Collectors.averagingInt(Person::getWeight))));

        data.forEach(results);
    }

    static class Person {
        private String gender;
        private int age;
        private int weight;

        private Person(String gender, int age, int weight) {
            this.gender = gender;
            this.age = age;
            this.weight = weight;
        }

        public String getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }

        public int getWeight() {
            return weight;
        }

        public static class Builder {
            private String gender;
            private int age;
            private int weight;

            public Builder gender(String gender) {
                this.gender = gender;
                return this;
            }

            public Builder age(int age) {
                this.age = age;
                return this;
            }

            public Builder weight(int weight) {
                this.weight = weight;
                return this;
            }

            public Person build() {
                return new Person(this.gender, this.age, this.weight);
            }
        }
    }
}
