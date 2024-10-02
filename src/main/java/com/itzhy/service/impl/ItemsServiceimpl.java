package com.itzhy.service.impl;

import com.itzhy.mapper.ItemMapper;
import com.itzhy.pojo.ItemStatuses;
import com.itzhy.pojo.ItemTransaction;
import com.itzhy.pojo.Items;
import com.itzhy.pojo.PageBean;
import com.itzhy.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemsServiceimpl implements ItemsService {
    @Autowired
    private ItemMapper itemMapper;
    //查询所有数据
    @Override
    public List<Items> selectAll() {

        return itemMapper.selectAll();
    }
//新增物品表里面的数据
    @Override
    public void increase(Items items) {
        itemMapper.increase(items);
    }
    //新增物品状态表的数据

    @Override
    public void increasestatuse(Integer ct) {
        //新建一个状态表的实体对象
        ItemStatuses itemStatuses=new ItemStatuses(null,ct,"1",LocalDate.now());//用1代表空闲2、代表借用3、代表维修这种
        itemMapper.increasestatuse(itemStatuses);
    }
//通过名称获取id
    @Override
    public Integer count(String name) {
        return itemMapper.count(name);
    }
//新增物资转流表
    @Override
    public void increasetransaction(Integer ct,Integer number,String state) {
        ItemTransaction itemTransaction=new ItemTransaction(null,ct,state,LocalDate.now(),number);
        itemMapper.increasetransaction(itemTransaction);
    }
//根据id查询状态
    @Override
    public String state(Integer id) {
        return itemMapper.state(id);
    }
//根据id获取数量
    @Override
    public Integer number(Integer id) {
        return itemMapper.number(id);
    }
//通过id获取整个表
    @Override
    public Items selectId(Integer id) {
        return itemMapper.selectId(id);
    }
//更新表格那一栏的数据
    @Override
    public void update(Items items) {
        itemMapper.update(items);
    }

    //更新对应物品状态表

    @Override
    public void updateStatus(Integer itemId, String status) {
        ItemStatuses itemStatuses=new ItemStatuses(null,itemId,status,LocalDate.now());
        itemMapper.updateStatus(itemStatuses);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        //获取总记录数
        Long count= itemMapper.all();
        //获取分页的列表
        Integer start=(page-1)*pageSize;
        List<Items> empList=itemMapper.page(start,pageSize);
        //封装pagebean对象
        PageBean pageBean=new PageBean(count,empList);
        return pageBean;
    }

    @Override
    public PageBean tjpage(Integer page, Integer pageSize, String itemName,String category,String location) {
        //获取总记录数
        Long count= itemMapper.tjall(itemName,category,location);
        //获取分页的列表
        Integer start=(page-1)*pageSize;
        List<Items> empList=itemMapper.tjpage(start,pageSize,itemName,category,location);
        //封装pagebean对象
        PageBean pageBean=new PageBean(count,empList);
        return pageBean;
    }

//批量删除操作

    @Override
    public void delete(List<Integer> ids) {
        itemMapper.delete(ids);
        itemMapper.deletest(ids);
        itemMapper.deletetr(ids);
    }

//    }

    //修改操作

    @Override
    public Items updateItem(Integer itemId, Items item) {
        itemMapper.updateItem(itemId,item);
        return itemMapper.selectId(itemId);
    }


    @Override
    public Items selectById(Integer ct) {
        Items items=itemMapper.selectId(ct);
        return items;
    }
}
