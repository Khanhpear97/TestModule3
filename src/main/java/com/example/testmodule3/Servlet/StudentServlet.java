package com.example.testmodule3.Servlet;

import com.example.testmodule3.Controller.StudentController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    protected StudentController studentController;

    @Override
    public void init() throws ServletException {
        studentController = new StudentController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";
        switch (action) {
            case "create":
                studentController.showFormCreate(req, resp);
                break;
            case "delete":
                try {
                    studentController.deleteStudent(req,resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                break;
            default:
                studentController.showListStudent(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";
        switch (action) {
            case "create":
                studentController.addStudent(req,resp);
                break;
            case "update":
                break;
        }
    }
}
