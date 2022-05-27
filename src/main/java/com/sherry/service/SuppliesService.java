package com.sherry.service;

import com.sherry.mapper.ResidentMapper;
import com.sherry.mapper.ResidentSuppliesRefMapper;
import com.sherry.mapper.SuppliesMapper;
import com.sherry.pojo.Resident;
import com.sherry.pojo.ResidentSuppliesRef;
import com.sherry.pojo.Supplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliesService {
    @Autowired
    SuppliesMapper suppliesMapper;
    @Autowired
    ResidentMapper residentMapper;
    @Autowired
    ResidentSuppliesRefMapper residentSuppliesRefMapper;
    public List<Supplies> selectAllSupplies(){
        return suppliesMapper.selectAllSupplies();
    }
    public void addSupplies(Supplies supplies){
        suppliesMapper.insertSupplies(supplies);
        //获取最新插入的物资的id(传入参数supplies没有id)
        int maxId = suppliesMapper.getMaxId();
        //在多对多关系中添加关系
        List<Resident> residentList = residentMapper.selectAllResidents();
        for(Resident resident:residentList){
            //先默认所有人都没领物资——getSituation为false
            residentSuppliesRefMapper.insertRecord(new ResidentSuppliesRef(resident.getResidentId(), maxId, false));
        }
    }
    public Integer deleteSuppliesById(Integer suppliesId){
        return suppliesMapper.deleteSuppliesById(suppliesId);
    }
    //某个供应品被某位居民领取
    public void updateSuppliesCountSituation(Integer suppliesId){
        Supplies supplies = suppliesMapper.getSuppliesById(suppliesId);
        supplies.setDistributeCount(supplies.getDistributeCount()+1);
        supplies.setRemainCount(supplies.getRemainCount()-1);
        suppliesMapper.updateSupplies(supplies);
    }
}
