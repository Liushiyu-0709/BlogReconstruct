package com.sherry.service;

import com.sherry.mapper.ResidentSuppliesRefMapper;
import com.sherry.pojo.Resident;
import com.sherry.pojo.ResidentSuppliesRef;
import com.sherry.pojo.Supplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentSuppliesRefService {
    @Autowired
    ResidentSuppliesRefMapper residentSuppliesRefMapper;

    public Integer insertRecord(ResidentSuppliesRef record){
        return residentSuppliesRefMapper.insertRecord(record);
    }
    public Integer updateRecord(ResidentSuppliesRef record){
        return residentSuppliesRefMapper.updateRecord(record);
    }

    public List<Resident> getResidentsByCriteria(Integer suppliesId, boolean getSituation){
        return residentSuppliesRefMapper.getResidentsByCriteria(suppliesId,getSituation);
    }

    public List<Supplies> getSuppliesByCriteria(Integer residentId, boolean getSituation){
        return residentSuppliesRefMapper.getSuppliesByCriteria(residentId,getSituation);
    }
    public Integer deleteRecordByResidentId(Integer residentId){
        return residentSuppliesRefMapper.deleteRecordByResidentId(residentId);
    }
    public Integer deleteRecordBySuppliesId(Integer suppliesId){
        return residentSuppliesRefMapper.deleteRecordBySuppliesId(suppliesId);
    }

}
