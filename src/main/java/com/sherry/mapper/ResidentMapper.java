package com.sherry.mapper;

import com.sherry.pojo.Resident;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResidentMapper {
    List<Resident> selectAllResidents();

    Integer insertResident(Resident resident);

    Integer updateResident(Resident resident);

    Integer deleteResidentById(Integer residentId);

    Integer getResidentCount();

    Resident getResidentById(Integer residentId);
}
