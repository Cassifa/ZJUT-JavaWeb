package zjut.lff.homework5.test2;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletContext;

import java.io.*;
import java.util.HashSet;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 2:27 2024/4/11
 * @ Description：工具类
 */
public class UserUtils {
    private static ServletContext servletContext;
    public static void setServletContext(ServletContext context) {
        servletContext = context;
    }
    public static boolean isValid(UserBean userBean) {
        HashSet<UserBean> set = getAll();
        for (UserBean now : set) {
            if (now.getName().equals(userBean.getName()) &&
                    now.getPassword().equals(userBean.getPassword())&&
            now.getId().equals(userBean.getId())&&
            now.getType().equals(userBean.getType()))
                return true;
        }
        return false;
    }

    public static HashSet<UserBean> getAll() {
        HashSet<UserBean> set = new HashSet<>();
        InputStream is = servletContext.getResourceAsStream("/WEB-INF/user.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\t");
                if (parts.length >= 4) {
                    String id = parts[0];
                    String password = parts[1];
                    String name = parts[2];
                    String userType = parts[3];
                    UserBean user = new UserBean(id, password, name, userType);
                    set.add(user);
                } else {
                    System.err.println("非法数据: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
        }
        return set;
    }

}
