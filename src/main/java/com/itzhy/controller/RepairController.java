package com.itzhy.controller;

import com.itzhy.pojo.Items;
import com.itzhy.pojo.Repair;
import com.itzhy.pojo.Result;
import com.itzhy.pojo.UpeateRepair;
import com.itzhy.service.RepairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//维修操作
@Slf4j
@RestController
@CrossOrigin
public class RepairController {
    @Autowired
    RepairService repairService;
    //查询维修表啥都查了
    @GetMapping("repair")
    public Result selectAll() {
      List<Repair> repair = repairService.selectAll();
      return Result.success(repair);
    }
    //根据账号查询
    @PostMapping("/selectUn")
    public Result selectUn(@RequestBody String userName)
    {
        userName = userName.replace("=", "").trim();

        log.info("输入的账号:{}",userName);
        List<Repair> repair= repairService.selectUn(userName);
        log.info("找到的数据:{}",repair);
        return Result.success(repair);
    }

    //查询没有维修过的
    @GetMapping("/selectSt")
    public Result selectSt()
    {
        List<Repair> repair=repairService.selectSt();
        return Result.success(repair);
    }
    //查询提交维修了没通过的
    @GetMapping("/selectps")
    public  Result selectps()
    {
        List<Repair> repair = repairService.selectps();
        return Result.success(repair);
    }

    //查询维修了没通过的
    @GetMapping("/selectwx")
    public Result selectwx()
    {
        List<Repair> repair=repairService.selectwx();
        return Result.success(repair);
    }
//新建维修
@PostMapping("/nrepair")
    public  Result  nrepair(@RequestBody Repair repair)
    {
        log.info("接收到的数据是:{}",repair);
        repairService.nrepair(repair);
        return Result.success();
    }
//维修
    @PostMapping("/erepair")
    public  Result erepair(@RequestBody UpeateRepair upeateRepair)
    {
        log.info("传入的数据是:{}",upeateRepair);
        repairService.erepair(upeateRepair.getRepairId(),upeateRepair.getRepairer());
        return Result.success();
    }
//维修审批通过
    @PostMapping("/passRepair")
    public  Result passRepair(@RequestBody UpeateRepair upeateRepair)
    {
        log.info("传入的数据是:{}", upeateRepair);
        repairService.passRepair(upeateRepair.getRepairId(),upeateRepair.getRepairer());
        return Result.success();
    }
    //维修审批不通过
    @PostMapping("/nopassRepair")
    public Result nopassRepair(@RequestBody UpeateRepair upeateRepair)
    {
        log.info("传入的数据是:{}",upeateRepair);
        repairService.nopassRepair(upeateRepair.getRepairId(),upeateRepair.getRepairer());

        return Result.success();
    }
 //维修后审批通过
 @PostMapping("/passRepaired")
 public Result passRepaired(@RequestBody UpeateRepair upeateRepair)
 {
     log.info("传入的数据是:{}",upeateRepair);
     repairService.passRepaired(upeateRepair.getRepairId());
     return Result.success();
 }
//维修后审批不通过
@PostMapping("/nopassRepaired")
    public Result nopassRepaired(@RequestBody UpeateRepair upeateRepair)
    {
        log.info("传入的数据是:{}",upeateRepair);
        repairService.nopassRepaired(upeateRepair.getRepairId());
        return Result.success();

    }

//删除操作
    @DeleteMapping("/repair/{ids}")
    public Result delete(@PathVariable List<Integer> ids)
    {
        repairService.delete(ids);

        return Result.success();
    }
//修改操作
    @PutMapping("/repair/{repairId}")
    public Result updateItem(@PathVariable Integer repairId, @RequestBody Repair repair) {
        Repair updateRepair = repairService.updateRepair(repairId, repair);
        if ( updateRepair != null) {
            return Result.success("修改成功");
        } else {
            return Result.success("修改失败");
        }
    }
}
