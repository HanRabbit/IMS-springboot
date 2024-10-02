package com.itzhy.service.impl;

import com.itzhy.mapper.ApprovalMapper;
import com.itzhy.pojo.ApprovalItem;
import com.itzhy.pojo.ApprovalItemRB;
import com.itzhy.pojo.Items;
import com.itzhy.pojo.Result;
import com.itzhy.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {
    @Autowired
    ApprovalMapper approvalMapper;

    @Override
    public void addApproval(ApprovalItem itemApproval) {
        approvalMapper.addApproval(itemApproval);
    }

    @Override
    public List<ApprovalItem> selectAll() {
        return approvalMapper.selectApproval();
    }

    @Override
    public void passApproval(ApprovalItemRB approvalItemRB) {
        approvalMapper.updateApprovalStatus(approvalItemRB);
    }

    @Override
    public void rejectApproval(ApprovalItemRB approvalItemRB) {
        approvalMapper.updateApprovalStatus(approvalItemRB);
    }
}
