package com.example.testmodule3.Controller;

import com.example.testmodule3.Entity.ClassRoom;
import com.example.testmodule3.Entity.Student;
import com.example.testmodule3.Model.StudentDAO;
import com.example.testmodule3.Model.StudentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class StudentController {
    protected StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentModel();
    }

    public void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Student> data;
        if (keyword == null) {
            data = this.studentDAO.getAll();
        } else {
            data = this.studentDAO.search(keyword);
            System.out.println(data);
        }

        req.setAttribute("students", data);
        RequestDispatcher view = req.getRequestDispatcher("views/students/list.jsp");
        view.forward(req,resp);
    }

    public void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<ClassRoom> classRooms = this.studentDAO.getClassRoom();
        req.setAttribute("classRooms", classRooms);
        RequestDispatcher view = req.getRequestDispatcher("/views/students/add.jsp");
        view.forward(req, resp);
    }

    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("date"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int className = Integer.parseInt(req.getParameter("class"));
        Student student = new Student(name, dateOfBirth, email, address, phone, className);
        this.studentDAO.save(student);
        resp.sendRedirect("/student");
    }

    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        this.studentDAO.delete(id);
        resp.sendRedirect("/student");
    }
}
