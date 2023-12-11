package com.example.testmodule3.Entity;

import java.time.LocalDate;

public class Student {
    protected int id;
    protected String studentName;
    protected LocalDate dateOfBirth;
    protected String email;
    protected String address;
    protected String phone;
    protected String className;

    protected int classId;

    public Student(int id,
                   String studentName,
                   LocalDate dateOfBirth,
                   String email,
                   String address,
                   String phone,
                   String classRoom) {
        this.id = id;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.className = classRoom;
    }

    public Student(String studentName,
                   LocalDate dateOfBirth,
                   String email,
                   String address,
                   String phone,
                   String classRoom) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.className = classRoom;
    }

    public Student(String studentName, LocalDate dateOfBirth, String email, String address, String phone, int classId) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
