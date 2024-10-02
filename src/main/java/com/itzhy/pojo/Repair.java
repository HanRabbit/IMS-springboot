package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
//维修表的数据
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repair {
    private Integer repairId;//维修的ID
    private String itemName;//物资名称
    private Integer itemQuantity;//物资数量
    private String location;//物资位置
    private String reason;//报修原因
    private Integer state;//状态
    private LocalDateTime createTime;//创建时间
    private LocalDateTime repairTime;//维修时间
    private String userName;//创建人
    private String repairer;//维修人
}
