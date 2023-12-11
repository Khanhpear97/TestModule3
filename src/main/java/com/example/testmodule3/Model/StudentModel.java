package com.example.testmodule3.Model;

import com.example.testmodule3.Database.Database;
import com.example.testmodule3.Entity.ClassRoom;
import com.example.testmodule3.Entity.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements StudentDAO{
    Connection conn;

    public StudentModel() {
        Database database = Database.getInstance();
        this.conn = database.connect();
    }
    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<Student>();
        try {
            String sql = "select s.id, s.studentName, s.dateOfBirth, s.email, s.address, s.phone, c.className from student s \n" +
                    "join class c on s.classId = c.id";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String studentName = rs.getString(2);
                LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String className = rs.getString(7);

                Student student = new Student(id, studentName, dateOfBirth, email, address, phone, className);
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
    @Override
    public List<ClassRoom> getClassRoom() {
        List<ClassRoom> classRooms = new ArrayList<ClassRoom>();
        try {
            String sql = "select * from class";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String className = rs.getString(2);

                ClassRoom classRoom = new ClassRoom(id, className);
                classRooms.add(classRoom);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return classRooms;
    }

    @Override
    public void save(Student student) {
        try {
            String sql = "INSERT INTO student(studentName, dateOfBirth, email, address, phone, classId) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            // gan gia tri cho tham so id
            statement.setString(1, student.getStudentName());
            statement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhone());
            statement.setInt(6, student.getClassId());
            // thu hien truy van
            statement.execute();
        }catch (SQLException e) {
            System.out.println("Add user fail" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            // gan gia tri cho tham so id
            statement.setInt(1, id);
            // thu hien truy van
            statement.execute();
        }catch (SQLException e) {
            System.out.println("Delete user fail" + e.getMessage());
        }
    }

    @Override
    public void edit(Student student) {
        try {
            String sql = "UPDATE student SET studentName = ?, dateOfBirth = ?, email = ?, address = ?, phone = ?, classId = ? WHERE id = ?  ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, student.getStudentName());
            statement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhone());
            statement.setInt(6, student.getClassId());
            statement.setInt(7, student.getId());
            statement.execute();
        }catch (SQLException e) {
            System.out.println("Update user fail" + e.getMessage());
        }
    }

    @Override
    public List<Student> search(String key) {
        List<Student> students = new ArrayList<Student>();
        try {
            String sql = "select s.id, s.studentName, s.dateOfBirth, s.email, s.address, s.phone, c.className from student s \n" +
                    "join class c on s.classId = c.id where s.studentName like ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, '%' + key + '%');
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String studentName = rs.getString(2);
                LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String className = rs.getString(7);

                Student student = new Student(id, studentName, dateOfBirth, email, address, phone, className);
                students.add(student);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public Student getById(int id) {
        Student student = null;
        try {
            String sql = "select s.studentName, s.dateOfBirth, s.email, s.address, s.phone, c.className from student s \n" +
                    "join class c on s.classId = c.id where s.id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                String studentName = rs.getString(1);
                LocalDate dateOfBirth = rs.getDate(2).toLocalDate();
                String email = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                String className = rs.getString(6);
                student = new Student(studentName, dateOfBirth, email, address, phone, className);
            }
        }catch (SQLException e) {
            System.out.println("Get user fail" + e.getMessage());
        }
        return student;
    }
}
