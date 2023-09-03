package org.example.model;

public class Student {

    private long id;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void printInformation(){
        System.out.println("1: -> CREATE TABLE");
        System.out.println("2: -> SAVE STUDENT");
        System.out.println("3: -> GET ALL STUDENT");
        System.out.println("4: -> GET BY ID STUDENT");
        System.out.println("5: -> UPDATE STUDENT");
        System.out.println("6: -> DELETE STUDENT");
        System.out.println("7: -> CLEAN TABLE");
        System.out.println("8: -> DROP TABLE");
    }
}
