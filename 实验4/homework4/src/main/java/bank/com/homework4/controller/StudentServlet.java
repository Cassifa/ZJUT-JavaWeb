package bank.com.homework4.controller;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 17:58 2024/4/3
 * @ Description：${description}
 */

import bank.com.homework4.pojo.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student=(Student) getServletContext().getAttribute("Student");
        if(student==null){
            student=new Student();
        }
        student.setStuid(request.getParameter("stuid"));
        student.setName(request.getParameter("name"));
        student.setMajor(request.getParameter("major"));
        request.getSession().setAttribute("student",student);
        //转发
        request.getRequestDispatcher("./test1/displayStudent.jsp").forward(request,response);
    }
}
