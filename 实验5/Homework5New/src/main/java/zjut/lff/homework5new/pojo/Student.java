package zjut.lff.homework5new.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 18:28 2024/5/8
 * @ Description：学生类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("dbt_student")
public class Student {
    private String name;
    private String id;
    private String sno;
    private String password;
    private String department;
    private String major;
    @TableField("class")
    private String studentClass;
}
