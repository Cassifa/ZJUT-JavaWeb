package zjut.lff.homework5.test2;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 2:25 2024/4/11
 * @ Description：${description}
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginActionServlet", value = "/LoginActionServlet")
public class LoginActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        UserBean userBean=new UserBean(id,password,name,type);
        System.out.println(userBean);
        UserUtils.setServletContext(getServletContext());
        if(!UserUtils.isValid(userBean)){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>账号名或密码错误</h2>");
            out.println("</body></html>");
            return;
        }
        HttpSession session= request.getSession();
        session.setAttribute("name",name);
        if(type.equals("教师")){
            request.getRequestDispatcher("./test2/teacher.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("./test2/student.jsp").forward(request,response);
        }
    }
}
