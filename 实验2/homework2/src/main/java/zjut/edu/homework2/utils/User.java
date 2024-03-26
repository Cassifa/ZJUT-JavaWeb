package zjut.edu.homework2.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:42 2024/3/15
 * @ Description：用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
    private String trueName;
    private String gender;
    private String email;
    private String phone;

}
