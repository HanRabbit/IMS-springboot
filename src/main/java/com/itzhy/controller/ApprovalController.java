package com.itzhy.controller;

import com.itzhy.pojo.ApprovalItem;
import com.itzhy.pojo.ApprovalItemRB;
import com.itzhy.pojo.Items;
import com.itzhy.pojo.Result;
import com.itzhy.service.ApprovalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class ApprovalController {
    @Autowired
    private ApprovalService approvalService;

    @PostMapping("/addApproval")
    public Result addApproval(@RequestBody ApprovalItem approvalItem) {
        approvalService.addApproval(approvalItem);
        return Result.success();
    }

    @PostMapping("/selectApproval")
    public Result selectApprovalTable() {
        List<ApprovalItem> itemApprovalList = approvalService.selectAll();
        return Result.success(itemApprovalList);
    }

    @PostMapping("/passApproval")
    public Result passApproval(@RequestBody ApprovalItemRB approvalItemRB) {
        approvalService.passApproval(approvalItemRB);
        return Result.success();
    }

    @PostMapping("/rejectApproval")
    public Result rejectApproval(@RequestBody ApprovalItemRB approvalItemRB) {
        approvalService.rejectApproval(approvalItemRB);
        return Result.success();
    }
}
