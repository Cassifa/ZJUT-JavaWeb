package zjut.lff.homework5.test3;

import com.alibaba.fastjson2.JSONArray;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;
import zjut.lff.homework5.test2.UserBean;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 16:52 2024/4/11
 * @ Description：作业工具类
 */
public class HomeworkUtils {

    private static ServletContext servletContext;

    public static void setServletContext(ServletContext context) {
        servletContext = context;
    }

    //允许某人下载
    public static boolean isValid(UserBean userBean, String homeworkName) {
        HashSet<HomeWork> set = HomeworkUtils.getAllHomework();
        for (HomeWork homeWork : set) {
            if (homeWork.getFilename().equals(homeworkName) && (
                    userBean.getType().equals("教师") || userBean.getId().equals(homeWork.getId())
            ))
                return true;
        }
        return false;
    }

    public static String getJsonHomeworks(UserBean userBean) {
        JSONArray jsonArray = new JSONArray();
        HashSet<HomeWork> set = HomeworkUtils.getAllHomework();
        for (HomeWork homeWork : set)
            if (userBean == null || userBean.getId().equals(homeWork.getId()))
                jsonArray.add(homeWork);
        return jsonArray.toJSONString();
    }

    private static HashSet<HomeWork> getAllHomework() {
        HashSet<HomeWork> set = new HashSet<>();
        InputStream is = servletContext.getResourceAsStream("/WEB-INF/homework.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\t");
                if (parts.length >= 5) {
                    String id = parts[0];
                    String name = parts[1];
                    String description = parts[2];
                    String date = parts[3];
                    String fileFullNme = parts[4];
                    //转时间//String转Date
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
                    HomeWork homeWork = new HomeWork(id, name, description,
                            date1, fileFullNme);
                    set.add(homeWork);
                } else {
                    System.err.println("非法数据: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    public static void saveHomework(Part part, HomeWork homeWork) throws IOException {
        String savePath = servletContext.getRealPath("/WEB-INF/files/");
        part.write(savePath + homeWork.getFilename());
        System.out.println("保存" + homeWork.getFilename());
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(savePath + "../" + "homework.txt", true))) {

            String workInfo = homeWork.getId() + "\t" + homeWork.getName() + "\t" +
                    homeWork.getDescription() + "\t" +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homeWork.getDate())
                    + "\t" + homeWork.getFilename();

            // 将用户信息写入文件
            writer.write(workInfo);
            writer.newLine(); // 换行

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
