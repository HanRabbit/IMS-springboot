package com.itzhy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApprovalItem {
    private String itemName;
    private Integer itemId;
    private Integer itemNumber;
    private Integer approvalStatus;
    private LocalDateTime approvalTime;
    private String approvalReason;
}
