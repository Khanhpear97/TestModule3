package com.example.testmodule3.Model;

import com.example.testmodule3.Entity.ClassRoom;
import com.example.testmodule3.Entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAll();
    void save(Student student);
    void delete(int id);
    void edit(Student student);

    public List<ClassRoom> getClassRoom();

    public Student getById(int id);

    List<Student> search(String key);
}
