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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@WebServlet(name = "loginServlet", value = "/loginServlet.do")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        //检测是否存在
        Set<User> set= UsersUtil.getAllUsers();
        for (User user : set) {
            if (user.getUserName().equals(userName)) {
                //存在 判断密码
                if (UsersUtil.passwordEncode(password)
                        .equalsIgnoreCase(user.getPassword())) {
                    //成功直接跳转
                    response.sendRedirect("welcome.html");
                    return;
                }
                //密码不匹配，跳转失败
//                request.setAttribute("message", "您的密码错误！");
//                response.sendRedirect("/failed.html");
                String errorMessage = "您的密码错误！";
                String redirectUrl = "failed.html?error=" +
                        URLEncoder.encode(errorMessage, StandardCharsets.UTF_8);
                response.sendRedirect(redirectUrl);
                return;
            }
        }
        //用户不存在 跳转失败
        // 设置请求属性
        String errorMessage = "用户名不存在！";
        String redirectUrl = "failed.html?error=" +
                URLEncoder.encode(errorMessage, StandardCharsets.UTF_8);
        // 重定向到 HTML 页面
        response.sendRedirect(redirectUrl);


    }
}
