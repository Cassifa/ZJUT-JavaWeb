package zjut.lff.homework5new.controller;
/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 18:11 2024/5/8
 * @ Description：${description}
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import zjut.lff.homework5new.Utils;
import zjut.lff.homework5new.pojo.Student;
import zjut.lff.homework5new.pojo.Teacher;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         // 获取请求参数

        String userType = request.getParameter("type");
        String id = null;
        String password = request.getParameter("password");
        String sno = request.getParameter("sno");
        String tno = request.getParameter("tno");
        if (sno != null&&!sno.equals("")) id = sno;
        else id = tno;

        if (userType == null || id == null || password == null) {
            response.sendRedirect("test2/failed.jsp"); // 如果必要字段为空，重定向到错误页面
            return;
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "";

            if ("学生".equals(userType)) {
                sql = "SELECT * FROM dbt_student WHERE sno = ? AND password = ?";
            } else if ("教师".equals(userType)) {
                sql = "SELECT * FROM dbt_teacher WHERE tno = ? AND password = ?";
            }

            pstmt = dbconn.prepareStatement(sql); // 创建预编译语句
            pstmt.setString(1, id); // 设置学号或工号
            pstmt.setString(2, Utils.passwordEncode(password));

            rs = pstmt.executeQuery(); // 执行查询

            if (rs.next()) { // 如果找到匹配记录
                if ("学生".equals(userType)) {
                    Student student = new Student();
                    student.setName(rs.getString("name"));
                    student.setId(rs.getString("id"));
                    student.setSno(rs.getString("sno"));
                    student.setMajor(rs.getString("major"));
                    student.setDepartment(rs.getString("department"));
                    student.setStudentClass(rs.getString("class"));
                    request.getSession().setAttribute("student", student);
                    response.sendRedirect("test2/student.jsp");
                } else if ("教师".equals(userType)) {
                    Teacher teacher = new Teacher();
                    teacher.setName(rs.getString("name"));
                    teacher.setId(rs.getString("id"));
                    teacher.setTno(rs.getString("tno"));
                    teacher.setDepartment(rs.getString("department"));
                    teacher.setRole(rs.getString("role"));
                    request.getSession().setAttribute("teacher", teacher);
                    response.sendRedirect("test2/teacher.jsp");
                }
            } else {
                response.sendRedirect("test2/error.jsp"); // 登录失败，重定向到登录页面
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close(); // 关闭 ResultSet
                if (pstmt != null) pstmt.close(); // 关闭 PreparedStatement
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userType = request.getParameter("type");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String tno = request.getParameter("tno");
        String sno = request.getParameter("sno");
        String password = request.getParameter("password");
        String department = request.getParameter("department");
        String role = request.getParameter("role");
        String major = request.getParameter("major");
        String className = request.getParameter("class");
        // 验证所有参数是否非空
        if (userType == null || name == null || id == null || password == null || department == null) {
            response.sendRedirect("test2/error.jsp");
            return;
        }
        if (userType.equals("学生") && (sno == null || major == null || className == null)) {
            response.sendRedirect("test2/error.jsp");
            return;
        }
        if (userType.equals("教师") && (tno == null || role == null)) {
            response.sendRedirect("test2/error.jsp");
            return;
        }

        PreparedStatement pstmt = null;
        String sql = null;
        try {
            // 根据用户类型选择插入到哪个表
            if ("学生".equals(userType)) {
                sql = "INSERT INTO dbt_student (name, id, password, department, sno, major, class) VALUES (?, ?, ?, ?, ?, ?, ?)";
                pstmt = dbconn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, id);
                pstmt.setString(3, Utils.passwordEncode(password));
                pstmt.setString(4, department);
                pstmt.setString(5, sno);
                pstmt.setString(6, major);
                pstmt.setString(7, className);
            } else if ("教师".equals(userType)) {
                sql = "INSERT INTO dbt_teacher (name, id, password, department, tno, role) VALUES (?, ?, ?, ?, ?, ?)";
                pstmt = dbconn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, id);
                pstmt.setString(3, Utils.passwordEncode(password));
                pstmt.setString(4, department);
                pstmt.setString(5, tno);
                pstmt.setString(6, role);
            }

            // 执行插入操作
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected <= 0)
                response.sendRedirect("test2/failed.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("test2/failed.jsp"); // 出现 SQL 错误时跳转到错误页面
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
