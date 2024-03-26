package zjut.edu.homework2;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 20:30 2024/3/14
 * @ Description：${description}
 */

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

@WebServlet(name = "computeTriangleArea", value = "/computeTriangleArea.do")
public class inputServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a=request.getParameter("a");
        String b=request.getParameter("b");
        String c=request.getParameter("c");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //html格式
        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        //判断
        Number aa,bb,cc;
        NumberFormat format=NumberFormat.getInstance();
            try {
                aa= format.parse(a);
                bb=format.parse(b);
                cc=format.parse(c);
                if(aa.doubleValue()<0||bb.doubleValue()<0||cc.doubleValue()<0){
                    out.println("输入的边长有误！");
                    out.println("</body></html>");
                    return;
                }
                double temp=aa.doubleValue()+bb.doubleValue()+cc.doubleValue();
                double ma=Math.max(aa.doubleValue(),Math.max(bb.doubleValue(),cc.doubleValue()));
                double mi2=temp-ma;
                if(ma>mi2){
                    out.println("三条边长无法构成三角形");
                    out.println("</body></html>");
                    return;
                }
                double s=temp/2;
                DecimalFormat df = new DecimalFormat("#.00");
                out.println("三角形面积="+
                        df.format(Math.sqrt(s * (s - aa.doubleValue()) * (s - bb.doubleValue()) * (s - cc.doubleValue()))));
                out.println("</body></html>");
            } catch (ParseException e) {
                out.println("输入的边长有误！");
                out.println("</body></html>");
                throw new RuntimeException(e);
            }
    }
}
