package bank.com.homework4.controller;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:37 2024/4/4
 * @ Description：${description}
 */

import bank.com.homework4.Utils.CustomerUtils;
import bank.com.homework4.model.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer=(Customer) getServletContext().getAttribute("Customer");
        if(customer==null){
            customer=new Customer();
        }
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String msg;
        //刷新用户列表
        CustomerUtils.refreshCustomers(customer);
        System.out.println("当前用户："+customer.getCustomers().toString());
        for(Customer now:customer.getCustomers()){
            if(now.getEmail().equals(email)){
                if(now.getPassword().equals(password)) {
                    msg = "欢迎" + now.getCustName() + "登录成功~";
                    request.getSession().setAttribute("msg",msg);
                    request.getRequestDispatcher("./bank/welcome.jsp").forward(request,response);
                    return;
                }
                else {
                    msg = "密码错误~";
                    request.getSession().setAttribute("msg",msg);
                    request.getRequestDispatcher("./bank/failed.jsp").forward(request,response);
                    return;
                }
            }
        }
        msg="登录失败，未找到此用户~";
        request.getSession().setAttribute("msg",msg);
        request.getRequestDispatcher("./bank/failed.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
