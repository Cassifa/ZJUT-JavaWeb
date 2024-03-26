package zjut.edu.homework2; /**
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 3:13 2024/3/16
 * @ Description：${description}
 */

import com.alibaba.fastjson.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import zjut.edu.homework2.utils.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ExportScoreServlet", value = "/export.do")
public class ExportScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //指定编码
        response.setHeader("Content-Encoding", "gb2312");
        //指示浏览器以附件的形式下载响应体内容 并指定文件编码
        response.setHeader("Content-Disposition",
                "attachment; filename=" + java.net.URLEncoder.encode("学生成绩.xls", StandardCharsets.UTF_8));
        //设置响应体格式格式
        response.setContentType("application/vnd.ms-excel;charset=gb2312");

        //获取数据
        String data=request.getParameter("jsonData");
        Student[] students = JSON.parseObject(data, Student[].class);
        PrintWriter out = response.getWriter();

        out.println("学号\t姓名\t课程\t分数\t");
        for(Student student:students){
            out.print(student.getStuid()+"\t");
            out.print(student.getName()+"\t");
            out.print(student.getCourseName()+"\t");
            out.print(student.getScore()+"\t");
            out.println("");
        }
        System.out.println(data);
    }
}
