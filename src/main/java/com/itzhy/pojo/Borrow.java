package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//借用的实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private Integer itemId;//物资的id
    private Integer quantity;//物资借用的数量
}
