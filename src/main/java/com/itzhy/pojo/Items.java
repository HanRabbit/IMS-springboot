package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//物资属性的实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    private Integer itemId;//物资的id
    private  String itemName;//物资的名字
    private String category;//物资的分类
    private Integer quantity;//物资的数量
    private String location;//物资的位置
}
