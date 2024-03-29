package zjut.edu.homework3;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 6:34 2024/3/29
 * @ Description：${description}
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zjut.edu.homework3.Utils.User;
import zjut.edu.homework3.Utils.UsersUtil;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "firstServlet", value = "/firstServlet.do")
public class firstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        Set<User> st= UsersUtil.getAllUsers();
        for(User user:st){
            if(userName.equals(user.getUserName())){
                if(UsersUtil.passwordEncode(password).equals(user.getPassword())){
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", userName);
                    // 重定向到 secondServlet
                    response.sendRedirect("secondServlet.do");
                    return;
                }
                else {
                    request.setAttribute("errorMsg","登录失败，密码错误~");
                    RequestDispatcher rd = request.getRequestDispatcher("hw/failed.jsp");
                    rd.forward(request, response);
                    return;
                }
            }

        }
        //未找到
        request.setAttribute("errorMsg","登录失败，未找到"+userName+"的信息");
        RequestDispatcher rd = request.getRequestDispatcher("hw/failed.jsp");
        rd.forward(request, response);
    }
}
