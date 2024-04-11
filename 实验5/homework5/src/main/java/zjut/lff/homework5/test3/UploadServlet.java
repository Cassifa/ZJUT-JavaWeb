package zjut.lff.homework5.test3;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 21:09 2024/4/11
 * @ Description：${description}
 */

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zjut.lff.homework5.SessionUtil;
import zjut.lff.homework5.test2.UserBean;
import zjut.lff.homework5.test2.UserUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //未登录
        if(!SessionUtil.isValid(request)){
            request.getRequestDispatcher("./test2/login.jsp").forward(request,response);
            return;
        }
        //当前登录用户
        HttpSession session=request.getSession(false);
        UserBean user= JSONObject.parseObject((String) session.getAttribute("user"),UserBean.class);
        //描述信息
        String description = request.getParameter("description");
        //文件
        Part part = request.getPart("file");
        String originalFileName = part.getSubmittedFileName();
        //后缀
        String fileExtension = "";
        int lastIndex = originalFileName.lastIndexOf('.');
        if (lastIndex > 0) {
            fileExtension = originalFileName.substring(lastIndex);
        }
        String finalName=(new Date().getTime()/1000)+"_"+user.getId()+fileExtension;

        HomeWork homeWork=new HomeWork(user.getId(), user.getName(),description,new Date(),finalName);
        //保存作业
        HomeworkUtils.setServletContext(getServletContext());
        HomeworkUtils.saveHomework(part,homeWork);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>"+homeWork.getFilename()+"上传成功"+"</h2>");
        out.println("</body></html>");
    }
}
