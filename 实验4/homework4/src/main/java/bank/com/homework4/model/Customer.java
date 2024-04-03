package bank.com.homework4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Vector;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:33 2024/4/4
 * @ Description：实验2Customer类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    public Vector<Customer> customers;
    private String email;
    private String password;
    private String custName;
    private String phone;
}
