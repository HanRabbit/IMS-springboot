package com.itzhy.mapper;

import com.itzhy.pojo.ItemStatuses;
import com.itzhy.pojo.ItemTransaction;
import com.itzhy.pojo.Items;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ItemMapper {
    //查询全部物资表
    @Select("select * from items")
    public List<Items> selectAll();
    //物资表新建
    @Insert("insert into items(item_name, category, quantity, location) values (#{itemName},#{category},#{quantity},#{location})")
   public void increase(Items items);
    //根据名字查询id
@Select("select item_id from items where item_name=#{name} ")
    public  Integer count(String name);
//状态表新增
@Insert("insert into item_statuses(item_id, status, status_change_date) values (#{itemId},#{status},#{statusChangeDate})")
 public void increasestatuse(ItemStatuses itemStatuses);
//新增流转表
@Insert("insert into item_transactions(item_id, transaction_type, transaction_date, quantity_changed) values(#{itemId},#{transactionType},#{transactionDate},#{quantityChanged})")
 public void increasetransaction(ItemTransaction itemTransaction);
//根据id查询状态
@Select("select status from item_statuses where item_id=#{itemId}")
  public   String state(Integer id);
//根据id查询对应的数量
@Select("select quantity from items where item_id=#{itemId}")
   public Integer number(Integer id);
//根据id查询那个id的所有数据
@Select("select * from items where item_id=#{itemId}")
   public Items selectId(Integer id);
//更新物品表数据
@Update("update items set item_name= #{itemName},category=#{category},quantity=#{quantity},location=#{location} where item_id=#{itemId}")
    void update(Items items);

//更新状态表数据
@Update("update item_statuses set status=#{status},status_change_date=#{statusChangeDate} where item_id=#{itemId}")
  public  void updateStatus(ItemStatuses itemStatuses);

//统计现在全部数据
@Select("select count(*)from items")
  public   Long all();

    //分页查询
    @Select("select * from items limit #{start},#{pageSize} ")
    public List<Items> page(Integer start,Integer pageSize);

   public Long tjall(String itemName,
                      String category,
                      String location);

    List<Items> tjpage(Integer start,  Integer pageSize,
                       String itemName,
                        String category,
                        String location);

    void delete(List<Integer> ids);
@Update("update items set item_name= #{item.itemName},category=#{item.category},quantity=#{item.quantity},location=#{item.location} where item_id=#{itemId}")
    void updateItem(Integer itemId, Items item);

    void deletest(List<Integer> ids);

    void deletetr(List<Integer> ids);
}
