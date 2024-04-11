package zjut.lff.homework5.test3;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 20:37 2024/4/11
 * @ Description：${description}
 */

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zjut.lff.homework5.SessionUtil;
import zjut.lff.homework5.test2.UserBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DownloadHomeworkServlet", value = "/DownloadHomeworkServlet.do")
public class DownloadHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //未登录
        if (!SessionUtil.isValid(request)) {
            request.getRequestDispatcher("./test2/login.jsp").forward(request, response);
            return;
        }

        UserBean user = JSONObject.parseObject(
                (String) request.getSession().getAttribute("user"), UserBean.class
        );
        String id = request.getParameter("id");
        String filename = request.getParameter("filename");
        //检查权限
        if (!HomeworkUtils.isValid(user, filename)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>您没有权限下载该作业</h2>");
            out.println("</body></html>");
            return;
        }
        String filePath = getServletContext().getRealPath("/WEB-INF/files/" + filename);
        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            // 设置响应内容类型
            response.setContentType("application/octet-stream");
            // 设置响应头，指定文件名
            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            // 读取文件并写入响应输出流
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 文件不存在或者不是一个文件
            // 在这里处理文件不存在的情况
            response.getWriter().println("文件不存在或者不是一个文件");
        }
    }
}
