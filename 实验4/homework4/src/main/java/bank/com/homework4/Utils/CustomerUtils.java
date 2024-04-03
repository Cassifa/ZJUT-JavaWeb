package bank.com.homework4.Utils;

import bank.com.homework4.model.Customer;

import java.io.*;
import java.util.Objects;
import java.util.Vector;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:54 2024/4/4
 * @ Description：实验2工具类
 */
public class CustomerUtils {
  //刷新CustomerBean的Vector
  public static void refreshCustomers(Customer customer) {
    Vector<Customer> now = new Vector<>();

    try (BufferedReader reader = new BufferedReader(
            new FileReader("customerinfo.txt"))
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        // 按 "|" 分隔行数据
        String[] fields = line.split("\\|");
        if (fields.length == 4) // 确保每行数据都包含了所有字段
          now.add(new Customer(null, fields[0], fields[1], fields[2], fields[3]));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    customer.setCustomers(now);
  }
  //保存一个Customer
  public static void saveCustomer(Customer customer) {
    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter("customerinfo.txt", true))) {

      String userInfo = customer.getEmail() + "|" + customer.getPassword() + "|" +
              customer.getCustName() + "|" + customer.getPhone();

      // 将用户信息写入文件
      writer.write(userInfo);
      writer.newLine(); // 换行
      System.out.println("写入成功");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
