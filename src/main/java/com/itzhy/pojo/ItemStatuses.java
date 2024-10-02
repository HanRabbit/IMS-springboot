package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
//物资状态表的实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemStatuses {
    private Integer statusId;//状态表的id
    private Integer itemId;//物资的id
    private String status;//物资的状态
    private LocalDate statusChangeDate;//修改的时间
}
