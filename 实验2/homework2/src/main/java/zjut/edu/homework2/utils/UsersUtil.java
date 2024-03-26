package zjut.edu.homework2.utils;

import org.bouncycastle.jcajce.provider.digest.SM3;
import org.bouncycastle.util.encoders.Hex;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:42 2024/3/15
 * @ Description：用户工具类
 */
public class UsersUtil {
    //获取所有userinfo已被注册用户
    public static Set<User> getAllUsers(){
        Set<User> users = new HashSet<>();

        //尝试读取userinfo.txt文件,不存在创建
        File file = new File("userinfo.txt");
        if (!file.exists()) {
            try {
                file.createNewFile(); // 如果文件不存在，则创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (
             BufferedReader reader = new BufferedReader(new InputStreamReader(
                     Objects.requireNonNull(UsersUtil.class.getResourceAsStream("/userinfo.txt"))
        ))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 按 "|" 分隔行数据
                String[] fields = line.split("\\|");
                if (fields.length == 6)//确保每行数据都包含了所有字段
                    users.add(
                            new User(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5])
                    );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(users);
        return users;
    }

    //记录一个用户(已经保证合法)
    public static Boolean saveUser(User user){
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(UsersUtil.class.getClassLoader().getResource("userinfo.txt").getPath(),
                                     true))) {
            // 使用 | 分隔字段，并加密密码
            String encryptedPassword = passwordEncode(user.getPassword());
            String userInfo = user.getUserName() + "|" + encryptedPassword + "|" +
                    user.getTrueName() + "|" + user.getGender() + "|" +
                    user.getEmail() + "|" + user.getPhone();

            // 将用户信息写入文件
            writer.write(userInfo);
            System.out.println("文件位置"+UsersUtil.class.getClassLoader().getResource("userinfo.txt").getPath());
            System.out.println(userInfo);
            writer.newLine(); // 换行
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //获取加密后字符串
    public static String passwordEncode(String password){
        MessageDigest digest = new SM3.Digest();
        byte[] hashBytes = digest.digest(password.getBytes());
        return Hex.toHexString(hashBytes).toUpperCase();
    }
}
