package zjut.lff.homework5new.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 18:28 2024/5/8
 * @ Description：
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("dbt_teacher")
public class Teacher {
    private String name;
    private String id;
    private String tno;
    private String password;
    private String department;
    private String role;
}
