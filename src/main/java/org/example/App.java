package org.example;

import org.example.model.Student;
import org.example.service.StudentService;
import org.example.service.impl.StudentServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {

        StudentService service = new StudentServiceImpl();
        while (true){
            Student.printInformation();
            int a = scanner.nextInt();
            if (a == 1){
                service.createStudent();
            }else if (a == 2){
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("AGE: ");
                int age = scanner.nextInt();
                service.saveStudent(new Student(name, age));
            }else if (a == 3){
                service.getAllStudent().forEach(System.out::println);
            }else if (a == 4){
                System.out.println("ID: ");
                int id = scanner.nextInt();
                System.out.println(service.getByIdStudent(id));
            }else if (a == 5){
                System.out.println("ID: ");
                int id = scanner.nextInt();
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("AGE: ");
                int age = scanner.nextInt();
                service.updateStudent(id, new Student(name, age));
                System.out.println("SUCCESSFULLY!!!");
            }else if (a == 6){
                System.out.println("ID: ");
                int id = scanner.nextInt();
                service.deleteByIdStudent(id);
                System.out.println("SUCCESSFULLY!!!");
            }else if (a == 7) {
                service.cleanTableStudent();
                System.out.println("SUCCESSFULLY!!!");
            }else if (a == 8){
                service.dropTable();
                System.out.println("SUCCESSFULLY!!!");

            }else {
                System.out.println("ERROR:");
            }
        }


    }
}
