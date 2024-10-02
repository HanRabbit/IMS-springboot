package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpeateRepair {
   private Integer repairId;//要修物资的id
   private String repairer;//维修人
}
