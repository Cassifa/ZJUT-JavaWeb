package bank.com.homework4.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 16:01 2024/4/4
 * @ Description：实验3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String id;
    private String son;
    private String phone;
    private String color;
    private Date date;
}
