package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImp;
import org.example.model.Student;
import org.example.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImp();

    public StudentServiceImpl() throws SQLException {
    }

    @Override
    public void createStudent() {
        studentDao.createStudent();
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public Student getByIdStudent(int age) {
        return studentDao.getByIdStudent(age);
    }

    @Override
    public void deleteByIdStudent(long id) {
        studentDao.deleteByIdStudent(id);
    }

    @Override
    public void updateStudent(long id, Student student) {
        studentDao.updateStudent(id, student);
    }

    @Override
    public void cleanTableStudent() {
        studentDao.cleanTableStudent();
    }

    @Override
    public void dropTable() {
        studentDao.dropTable();
    }
}
