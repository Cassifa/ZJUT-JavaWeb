package zjut.lff.homework5.test3;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 16:48 2024/4/11
 * @ Description：作业类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeWork {
    private String id;
    private String name;
    private String description;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String filename;
}
