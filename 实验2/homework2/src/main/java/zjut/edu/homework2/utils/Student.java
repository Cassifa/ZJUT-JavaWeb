package zjut.edu.homework2.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 3:02 2024/3/16
 * @ Description：学生类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String stuid;
    private String name;
    private String courseName;
    private Integer score;
}
