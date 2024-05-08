package zjut.lff.homework5new.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 9:38 2024/5/4
 * @ Description：
 */
//@SuppressWarnings("all")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String prodId;
    private String pname;
    private double price;
    private int stock;
}
