package zjut.lff.homework5new.controller;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 9:40 2024/5/4
 * @ Description：${description}
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import zjut.lff.homework5new.pojo.Product;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "QueryProductServlet", value = "/queryproduct.do")
public class QueryProductServlet extends HttpServlet {
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
        } catch (ClassNotFoundException e1) {
            System.out.println(e1);
        } catch (SQLException e2) {
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String productid = request.getParameter("productid");
        try {
            String sql = "SELECT * FROM products WHERE prod_id = ?";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            pstmt.setString(1, productid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()) {
                Product product = new Product();
                product.setProdId(rst.getString("prod_id"));
                product.setPname(rst.getString("pname"));
                product.setPrice(rst.getDouble("price"));
                product.setStock(rst.getInt("stock"));
                request.getSession().setAttribute("product", product);
                response.sendRedirect("displayProduct.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> productList = null;
        productList = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM products";
            PreparedStatement pstmt = dbconn.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                Product product = new Product();
                product.setProdId(result.getString("prod_id"));
                product.setPname(result.getString("pname"));
                product.setPrice(result.getDouble("price"));
                product.setStock(result.getInt("stock"));
                productList.add(product);
            }
            if (!productList.isEmpty()) {
                request.getSession().setAttribute("productList", productList);
                response.sendRedirect("displayAllProduct.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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