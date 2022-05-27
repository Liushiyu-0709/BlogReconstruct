package com.sherry.service;

import com.sherry.mapper.ResidentMapper;
import com.sherry.pojo.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {
    @Autowired
    ResidentMapper residentMapper;
    public List<Resident> selectAllResidents(){
        return residentMapper.selectAllResidents();
    }
    //未定参数
    public Integer insertResident(Resident resident){
        return residentMapper.insertResident(resident);
    }
    public Integer updateResident(Resident resident){
        return residentMapper.updateResident(resident);
    }
    public Integer deleteResidentById(Integer id){
        return residentMapper.deleteResidentById(id);
    }
    public Integer getResidentCount(){
        return residentMapper.getResidentCount();
    }
    public Resident getResidentById(Integer residentId){
        return residentMapper.getResidentById(residentId);
    }
}

