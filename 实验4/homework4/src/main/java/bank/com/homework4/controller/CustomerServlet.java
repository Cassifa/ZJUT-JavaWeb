package bank.com.homework4.controller;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:36 2024/4/4
 * @ Description：${description}
 */

import bank.com.homework4.Utils.CustomerUtils;
import bank.com.homework4.model.Customer;
import bank.com.homework4.pojo.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet.do")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer=(Customer) getServletContext().getAttribute("Customer");
        if(customer==null){
            customer=new Customer();
        }
        customer.setEmail(request.getParameter("email"));
        customer.setPassword(request.getParameter("password"));
        customer.setCustName(request.getParameter("name"));
        customer.setPhone(request.getParameter("phone"));
        CustomerUtils.saveCustomer(customer);
        request.getSession().setAttribute("customer",customer);

        request.getRequestDispatcher("./bank/displayCustomer.jsp").forward(request,response);
    }
}
