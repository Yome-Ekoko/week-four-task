package models;

import enums.Gender;

public abstract class Person {
    private String name;
    private Gender gender;
    private String email;
   private Integer age;


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Gender gender, String email, Integer age) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

