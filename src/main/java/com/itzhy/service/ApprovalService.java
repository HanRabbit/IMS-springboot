package com.itzhy.service;

import com.itzhy.pojo.ApprovalItem;
import com.itzhy.pojo.ApprovalItemRB;
import com.itzhy.pojo.Items;

import java.util.List;

public interface ApprovalService {
    List<ApprovalItem> selectAll();

    /* 添加物资申请列表 */
    void addApproval(ApprovalItem itemApproval);

    /* 物资申请通过 */
    void passApproval(ApprovalItemRB approvalItemRB);

    /* 物资申请未通过 */
    void rejectApproval(ApprovalItemRB approvalItemRB);
}
