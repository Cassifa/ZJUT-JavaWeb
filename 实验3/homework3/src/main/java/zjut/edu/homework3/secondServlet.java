package zjut.edu.homework3;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 6:34 2024/3/29
 * @ Description：${description}
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "secondServlet", value = "/secondServlet.do")
public class secondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        if(userName != null) {
            // 如果用户信息存在，展示用户信息
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>用户信息</title></head>");
            out.println("<body>");
            out.println("<h1>用户信息：</h1>");
            out.println("<p>用户名: " + userName + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
