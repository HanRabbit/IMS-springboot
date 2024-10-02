package com.itzhy.mapper;

import com.itzhy.pojo.Repair;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface RepairMapper {
    //查询操作
    public List<Repair> select(Integer state,String userName) ;

    //新增操作
    @Insert("insert into repair_item(ITEM_NAME, ITEM_QUANTITY, LOCATION, REASON,state, CREATE_TIME, REPAIR_TIME, USER_NAME) VALUES (#{itemName},#{itemQuantity},#{location},#{reason},#{state},#{createTime},#{repairTime},#{userName})")
    void nrepair(Repair repair);

    //维修操作
    @Update("update repair_item set state=#{state},repair_time=#{repairTime} ,repairer=#{repairer} where repair_id=#{repairId}")
    void erepair(Integer repairId, LocalDateTime repairTime, Integer state, String repairer);

    //查询全部
    @Select("select * from repair_item")
    List<Repair> selectAll();

    //根据用户名查询自己的报修
    @Select("select * from repair_item where user_name=#{userName}")
    List<Repair> selectUn(String userName);
    //多项删除
    void delete(List<Integer> ids);

   //修改自己提交的维修操作
    @Update("UPDATE repair_item SET item_name=#{repair.itemName}, item_quantity=#{repair.itemQuantity}, location=#{repair.location}, reason=#{repair.reason}, create_time=#{repair.createTime} WHERE repair_id=#{repairId}")
    void updateRepair( Integer repairId, Repair repair);

    //根据id查询
    @Select("select * from repair_item where repair_id=#{repairId}")
    Repair getbyId(Integer repairId);
    //报修审批
@Update("update repair_item set state=#{state} where repair_id=#{repairId}")
    void passRepair(Integer repairId, Integer state);
//维修后审批
    @Update("update repair_item set state=#{state} where repair_id=#{repairId}")
    void passRepaired(Integer repairId, Integer state);
}
