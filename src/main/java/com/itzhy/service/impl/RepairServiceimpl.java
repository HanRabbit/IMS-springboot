package com.itzhy.service.impl;

import com.itzhy.mapper.RepairMapper;
import com.itzhy.pojo.Repair;
import com.itzhy.service.RepairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class RepairServiceimpl implements RepairService {
    @Autowired
    RepairMapper repairMapper;
    @Override
    public List<Repair> selectAll() {
        return repairMapper.selectAll();
    }

    @Override
    public List<Repair> selectUn(String userName) {
        return repairMapper.selectUn(userName);
    }
    //查询没有修过的
    @Override
    public List<Repair> selectSt() {
        return repairMapper.select(1,null);
    }
   //查询报修了但是没审批的

    //找维修前审批没通过的
    @Override
    public List<Repair> selectps() {
        return repairMapper.select(3,null);
    }
    //查找维修后没审批的
    @Override
    public List<Repair> selectwx() {
        return repairMapper.select(4,null);
    }

    //创建操作
    @Override
    public void nrepair(Repair repair) {
        repair.setCreateTime(LocalDateTime.now());
        repair.setState(3);
        repairMapper.nrepair(repair);
    }
    //维修操作
    @Override
    public void erepair(Integer repairId,String repairer) {
        LocalDateTime localDateTime=LocalDateTime.now();
        Integer state=4;
        repairMapper.erepair(repairId,localDateTime,state,repairer);
    }

    //报修审批审批操作

    @Override
    public void passRepair(Integer repairId, String repairer) {
        Integer state=1;
        repairMapper.passRepair(repairId,state);
    }
    //报修审批不通过操作

    @Override
    public void nopassRepair(Integer repairId, String repairer) {
        Integer state=5;
        repairMapper.passRepair(repairId,state);
    }

//维修审批通过

    @Override
    public void passRepaired(Integer repairId) {
        Integer state=2;
        repairMapper.passRepaired(repairId,state);
    }

//维修审批未通过

    @Override
    public void nopassRepaired(Integer repairId) {
        Integer state=6;
        repairMapper.passRepaired(repairId,state);
    }

    //多项删除

    @Override
    public void delete(List<Integer> ids) {
        repairMapper.delete(ids);
    }

    //物资修改操作


    @Override
    public Repair updateRepair(Integer repairId, Repair repair) {
repair.setCreateTime(LocalDateTime.now());
        repairMapper.updateRepair(repairId,repair);
       Repair updaterepair = repairMapper.getbyId(repairId);
        return updaterepair;
    }
}
