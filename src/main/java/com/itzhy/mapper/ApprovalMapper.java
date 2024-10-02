package com.itzhy.mapper;

import com.itzhy.pojo.ApprovalItem;
import com.itzhy.pojo.ApprovalItemRB;
import com.itzhy.pojo.Items;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ApprovalMapper {
    /* 向物资申请表中插入数据 */
    @Insert("INSERT INTO item_approval(item_name, item_number, approval_reason) VALUES (#{itemName}, #{itemNumber}, #{approvalReason})")
    void addApproval(ApprovalItem approvalItem);

    /* 向物资申请表中查询数据 */
    @Select("SELECT * FROM item_approval")
    List<ApprovalItem> selectApproval();

    /* 修改物资申请状态 */
    @Update("UPDATE item_approval SET approval_status=#{status} WHERE item_id=#{id}")
    void updateApprovalStatus(ApprovalItemRB approvalItemRB);
}
