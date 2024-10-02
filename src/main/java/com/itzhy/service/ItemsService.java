package com.itzhy.service;

import com.itzhy.pojo.Items;
import com.itzhy.pojo.PageBean;

import java.util.List;

public interface ItemsService {
    List<Items> selectAll();

    void increase(Items items);

    void increasestatuse(Integer ct);

    Integer count(String name);

    void increasetransaction(Integer ct,Integer number,String state);

    String state(Integer id);

    Integer number(Integer id);

    Items selectId(Integer id);

    void update(Items items);

    void updateStatus(Integer itemId, String status);

    PageBean page(Integer page, Integer pageSize);

    PageBean tjpage(Integer page, Integer pageSize, String itemName,String category,String location);

    void delete(List<Integer> ids);

    Items updateItem(Integer itemId, Items item);

    Items selectById(Integer ct);

//    long zhaocuo(String itemName, String category, String locaion);
}
