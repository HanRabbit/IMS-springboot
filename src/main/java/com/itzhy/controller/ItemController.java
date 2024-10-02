package com.itzhy.controller;

import com.itzhy.mapper.ItemMapper;
import com.itzhy.pojo.*;
import com.itzhy.service.ItemsService;
import com.itzhy.service.RepairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j//记录日志log
@RestController
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemsService itemsService;
    //查询所有数据
    @GetMapping("/items")
    public Result selectAll(){
        List<Items> items=itemsService.selectAll();
        log.info("查询物品表的所有数据");
        return Result.success(items);
    }
    //新增数据
    @PostMapping("/items")
    public  Result increase(@RequestBody Items items)
    {
    log.info("新增物资");
    //新建物资表
    itemsService.increase(items);
    //查询新添加物资表的id
    Integer ct= itemsService.count(items.getItemName());
    //新建状态表
    itemsService.increasestatuse(ct);
    //新建物品转流表
    itemsService.increasetransaction(ct,items.getQuantity(),"入库");//这个想改啥改啥
    return Result.success(itemsService.selectById(ct));
    }
    //借用
@PostMapping("/itemsbr")
    public Result borrow(@RequestBody Borrow br)
    {
        log.info("借用物资");
        //获取要借用的物资的状态
       String state = itemsService.state(br.getItemId());
//如果要借用的物资状态是可以借用
       if ("空闲".equals(state) || "1".equals(state))
       {
           //获取当前物资的数量
           Integer number=itemsService.number(br.getItemId());
           if(number!=null)
           {
               //相减将数据留作备用
               if(number> br.getQuantity())
               {
                   number=number-  br.getQuantity();
               } else if (number.equals( br.getQuantity())) {
                   number=number-  br.getQuantity();
                   itemsService.updateStatus(br.getItemId(),"2");
               }
               else {
                   return Result.error("申请数量过多");
               }

           }


           //新增物资转流表
           itemsService.increasetransaction(br.getItemId(),  br.getQuantity(), "出库");
           //通过id来获取这一栏表格
           Items items=   itemsService.selectId(br.getItemId());
           //更新表格
           items.setQuantity(number);

           itemsService.update(items);

           //更新浏览器数据
           return Result.success(itemsService.selectAll());
       }
       else {
          return Result.error("这条数据状态不可用");
       }

    }
    //归还
    @PostMapping("/itemsre1")
    public Result return1(@RequestBody Borrow re)
    {
        log.info("归还物资");
        //获取当前物资数目

        Integer number=itemsService.number(re.getItemId());
        if(number.equals(0))//如果当前数量为0，代表状态为不能借要更新状态
        {
            itemsService.updateStatus(re.getItemId(), "1");//更新状态
        }
        //相加留作更新用
        number=number+ re.getQuantity();
        //新增物资转流表
        itemsService.increasetransaction(re.getItemId(),re.getQuantity(),"入库");
        //获取那一栏的表格到实体类，并且更新物资数量
        Items items=   itemsService.selectId(re.getItemId());
        items.setQuantity(number);
        //更新表格
        itemsService.update(items);
        //更新浏览器数据
        return Result.success(itemsService.selectAll());
    }
//分页查询
    @GetMapping("/itemsfy")
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer pageSize
                      ){
        log.info("分页查询:{}，{}",page,pageSize);
        PageBean pageBean=itemsService.page(page,pageSize);
        return Result.success(pageBean);
    }

    //条件分页查询
    @GetMapping ("/itemsfy/tj")
    public Result tjpage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10")Integer pageSize,@RequestParam(required = false) String itemName,@RequestParam(required = false) String category ,@RequestParam(required = false) String location)
    {
        log.info("条件分页查询");
        PageBean pageBean=itemsService.tjpage(page,pageSize,itemName,category,location);
        return Result.success(pageBean);

    }

//    @PostMapping("/zhaocuo")
//    public  Result zhaocuo(@RequestParam(required = false ) String itemName,@RequestParam(required = false) String category,@RequestParam(required = false) String locaion)
//    {
//   long i= itemsService.zhaocuo(itemName,category,locaion);
//    return Result.success(i);
//    }

    //多项删除
    @DeleteMapping("/items/{ids}")
    public Result delete(@PathVariable List<Integer> ids)
    {
        itemsService.delete(ids);

        return Result.success();
    }
//物资修改操作
@PutMapping("/items/{itemId}")
public Result updateItem(@PathVariable Integer itemId, @RequestBody Items item) {
    Items updatedItem = itemsService.updateItem(itemId, item);
    if (updatedItem != null) {
        return Result.success("修改成功");
    } else {
        return Result.success("修改失败");
    }
}


}
