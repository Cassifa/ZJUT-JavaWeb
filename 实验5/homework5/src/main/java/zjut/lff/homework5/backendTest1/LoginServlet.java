package zjut.lff.homework5.backendTest1;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 0:15 2024/4/11
 * @ Description：${description}
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import zjut.lff.homework5.SessionUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //如果已经登录过不在新注册session
        if(SessionUtil.isValid(request)){
            request.getRequestDispatcher("./FileDownloadServlet").forward(request,response);
        }
        else if(name.equals("admin")&&password.equals("12345678a")){
            //登录成功，新建session
            HttpSession session1=request.getSession();
            Cookie cookie=new Cookie("JSESSIONID",session1.getId());
            //与session时长相同
            cookie.setMaxAge(60*30);
            response.addCookie(cookie);
            request.getRequestDispatcher("./FileDownloadServlet").forward(request,response);
        }
        else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>账号名或密码错误</h2>");
            out.println("</body></html>");
        }
    }
}
