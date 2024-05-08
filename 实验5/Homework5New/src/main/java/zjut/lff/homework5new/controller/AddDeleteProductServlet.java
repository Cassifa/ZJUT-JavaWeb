package zjut.lff.homework5new.controller;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 14:42 2024/5/8
 * @ Description：${description}
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddDeleteProductServlet", value = "/AddDeleteProductServlet")
public class AddDeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection dbconn = null;

    public void init() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/javaweb?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "254519";
        try {
            Class.forName(driver);
            dbconn = DriverManager.getConnection(dburl, username, password);
            System.out.println(dburl + username + password);
        } catch (ClassNotFoundException e1) {
            System.out.println(e1);
        } catch (SQLException e2) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productid = request.getParameter("productid");

        try {
            // SQL 语句，用于根据 productid 删除商品
            String sql = "DELETE FROM products WHERE prod_id = ?";

            // 使用 PreparedStatement 来设置参数并执行 SQL
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1, productid);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0)
                response.sendRedirect("queryproduct.do");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取产品信息
        String prodId = request.getParameter("prodId");
        String pname = request.getParameter("pname");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        PreparedStatement pstmt = null;
        try {
            // 插入 SQL 语句
            String sql = "INSERT INTO products (prod_id, pname, price, stock) VALUES (?, ?, ?, ?)";

            // 使用 PreparedStatement 来防止 SQL 注入
            pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1, prodId);
            pstmt.setString(2, pname);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, stock);

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0)
                response.sendRedirect("queryproduct.do");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 在需要时关闭数据库连接和 PreparedStatement
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void destroy() {
        try {
            dbconn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
