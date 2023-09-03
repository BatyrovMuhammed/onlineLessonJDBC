package org.example.dao;

import org.example.model.Student;

import java.util.List;

public interface StudentDao {

    void createStudent();

    void saveStudent(Student student);

    List<Student> getAllStudent();

    Student getByIdStudent(int age);

    void deleteByIdStudent(long id);

    void updateStudent(long id, Student student);

    void cleanTableStudent();

    void dropTable();
}
