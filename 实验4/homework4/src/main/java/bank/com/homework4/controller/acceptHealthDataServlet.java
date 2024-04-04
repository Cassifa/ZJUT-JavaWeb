package bank.com.homework4.controller;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 4:13 2024/4/4
 * @ Description：${description}
 */

import bank.com.homework4.model.Customer;
import bank.com.homework4.pojo.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "acceptHealthDataServlet", value = "/acceptHealthDataServlet")
public class acceptHealthDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String son = request.getParameter("son");
        String phone = request.getParameter("phone");
        String radio1 = request.getParameter("radio1");
        String radio2 = request.getParameter("radio2");
        String radio3 = request.getParameter("radio3");
        String radio4 = request.getParameter("radio4");
        String checked2 = request.getParameter("checked2");
        String checked3 = request.getParameter("checked3");
        String checked4 = request.getParameter("checked4");
        String checked5 = request.getParameter("checked5");
        String checked6 = request.getParameter("checked6");
        String checked7 = request.getParameter("checked7");
        String checked10 = request.getParameter("checked10");

        //设置二维码颜色
        String color;
        while (true){
            //直接红码
            if(radio3.equals("1")||radio4.equals("1")){
                color="red";
                break;
            }
            int t=0;
            //条件红码
            if(checked2!=null&&checked2.equals("true"))t++;
            if(checked3!=null&&checked3.equals("true"))t++;
            if(checked4!=null&&checked4.equals("true"))t++;
            if(checked5!=null&&checked5.equals("true"))t++;
            if(checked6!=null&&checked6.equals("true"))t++;
            if(checked7!=null&&checked7.equals("true"))t++;
            if(checked10!=null&&checked10.equals("true"))t++;
            if(t>=2){
                color="red";
                break;
            }
            //黄码
            if(t!=0||radio1.equals("1")||radio2.equals("1"))
                color="yellow";
            else color="green";
            break;
        }

        //创建bean
        User user=(User) getServletContext().getAttribute("User");
        if(user==null){
            user=new User(name,id,son,phone,color,new Date());
        }

        request.getSession().setAttribute("user",user);

        request.getRequestDispatcher("./test3/show.jsp").forward(request,response);
    }
}
