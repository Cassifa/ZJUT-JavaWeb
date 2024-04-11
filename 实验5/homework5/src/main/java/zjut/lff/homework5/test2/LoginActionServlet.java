package zjut.lff.homework5.test2;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 2:25 2024/4/11
 * @ Description：${description}
 */

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zjut.lff.homework5.test3.HomeworkUtils;

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
        UserUtils.setServletContext(getServletContext());
        if(!UserUtils.isValid(userBean)){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>账号名或密码错误</h2>");
            out.println("</body></html>");
            return;
        }
        //登录后session存userBean-user userName-name
        HttpSession session= request.getSession();
        session.setAttribute("name",name);
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        //与session时长相同
        cookie.setMaxAge(60*30);
        response.addCookie(cookie);
        session.setAttribute("user", JSON.toJSONString(userBean));
        if(type.equals("教师")){
            //实验二用下面这行代码
//            request.getRequestDispatcher("./test2/teacher.jsp").forward(request,response);
            request.getRequestDispatcher("./test3/AllHomeworkServlet").forward(request,response);
        }
        else {
            //实验二用下面这行代码
//            request.getRequestDispatcher("./test2/student.jsp").forward(request,response);
            response.sendRedirect("test3/studentOperation.jsp");

        }
    }
}
