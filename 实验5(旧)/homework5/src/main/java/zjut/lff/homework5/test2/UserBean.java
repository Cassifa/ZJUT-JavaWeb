package zjut.lff.homework5.test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 2:22 2024/4/11
 * @ Description：用户pojo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private String id;
    private String password;
    private String name;
    private String type;
}
