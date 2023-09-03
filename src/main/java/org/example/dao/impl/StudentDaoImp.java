package org.example.dao.impl;

import org.example.comfig.JDBCConfig;
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp implements StudentDao {

    public final Connection connection;

    public StudentDaoImp() throws SQLException {
        connection = new JDBCConfig().getConnection();

    }

    //CREATE TABLE
    @Override
    public void createStudent() {
        String sql = """
                create table students(
                id serial primary key,
                name varchar(50) not null,
                age int
                );
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SAVE STUDENT
    @Override
    public void saveStudent(Student student) {
        String sql = """
                insert into students(name, age) values (?, ?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // GET ALL STUDENT
    @Override
    public List<Student> getAllStudent() {
        String sql = "select * from students";
        List<Student> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong(1));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt(3));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //GET BY ID STUDENT
    @Override
    public Student getByIdStudent(int age) {
        String sql = """
                select * from students where age = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("ERROR NOT FOUND ID:");
            }
            Student student = new Student();
            student.setId(resultSet.getLong(1));
            student.setName(resultSet.getString(2));
            student.setAge(resultSet.getInt(3));
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //DELETE BY ID STUDENT
    @Override
    public void deleteByIdStudent(long id) {
        String sql = "delete from students where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    //UPDATE STUDENT
    @Override
    public void updateStudent(long id, Student student) {
        String sql = """
                update students set name = ?, age = ? where id = ?
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setLong(3,id);
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //CLEAN TABLE
    @Override
    public void cleanTableStudent() {
        String sql = "truncate students";
        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //DROP TABLE
    @Override
    public void dropTable() {
        String sql = "drop table students";
        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
