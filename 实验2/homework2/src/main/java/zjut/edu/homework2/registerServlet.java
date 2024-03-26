package zjut.edu.homework2; /**
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:39 2024/3/15
 * @ Description：${description}
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zjut.edu.homework2.utils.User;
import zjut.edu.homework2.utils.UsersUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@WebServlet(name = "registerServlet", value = "/registerServlet.do")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String trueName=request.getParameter("trueName");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");

        Set<User> set= UsersUtil.getAllUsers();
        for (User user : set) {
            if (user.getUserName().equals(userName)) {
                //用户重复 返回
                String htmlResponse = "<html><body><h2>用户名已存在，请重新输入。" +
                        "<a href=\"./register.html\">点击返回</a>" +
                        "</h2></body></html>";
                response.getOutputStream().write(htmlResponse.getBytes(StandardCharsets.UTF_8));
                return;
            }
        }
        Boolean success=UsersUtil.saveUser(new User(userName,password
                ,trueName,gender,email,phone));
        if(Boolean.TRUE.equals(success))
            response.setHeader("Refresh","5;URL=\"welcome.html");

    }
}
