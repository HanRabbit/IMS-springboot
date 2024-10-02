package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
//物资流转表的实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemTransaction {
    private Integer transactionId;//流转表的id
    private Integer itemId;//物资id
    private String transactionType;//流转的类型
    private LocalDate transactionDate;//流转的日期
    private Integer quantityChanged;//修改的数量
}
