package zjut.lff.homework5.test1;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 0:14 2024/4/11
 * @ Description：${description}
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zjut.lff.homework5.SessionUtil;

import java.io.*;

@WebServlet(name = "FileDownloadServlet", value = "/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(SessionUtil.isValid(request)){
            // 获取文件的真实路径
            String filePath = getServletContext().getRealPath("/WEB-INF/files/servlet.pdf");
            // 设置文件MIME类型
            response.setContentType("application/pdf");
            // 设置Content-Disposition
            response.setHeader("Content-Disposition", "attachment;filename=servlet.pdf");
            // 读取文件，并输出到response
//            try (InputStream inputStream = new FileInputStream(filePath);
//                 OutputStream outputStream = response.getOutputStream()) {
//                byte[] buffer = new byte[4096];
//                int bytesRead;
//                while ((bytesRead = inputStream.read(buffer)) != -1) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
//            } catch (IOException e) {
//                throw new ServletException("找不到文件", e);
//            }
        }
        else {
            response.sendRedirect("./test1/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
