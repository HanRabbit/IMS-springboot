package com.itzhy.service;

import com.itzhy.pojo.Repair;

import java.util.List;

public interface RepairService {
    List<Repair> selectAll();

    List<Repair> selectUn(String userName);

    List<Repair> selectSt();

    void nrepair(Repair repair);

    void erepair(Integer repairId,String repairer);

    void delete(List<Integer> ids);



    Repair updateRepair(Integer repairId, Repair repair);

    void passRepair(Integer repairId, String repairer);

    void passRepaired(Integer repairId);

    List<Repair> selectps();

    void nopassRepair(Integer repairId, String repairer);

    void nopassRepaired(Integer repairId);

    List<Repair> selectwx();
}
