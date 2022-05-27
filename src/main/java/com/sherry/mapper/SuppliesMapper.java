package com.sherry.mapper;

import com.sherry.pojo.Resident;
import com.sherry.pojo.Supplies;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuppliesMapper {
    List<Supplies> selectAllSupplies();

    Integer insertSupplies(Supplies supplies);

    Integer updateSupplies(Supplies supplies);

    Integer deleteSuppliesById(Integer suppliesId);

    Integer getMaxId();

    Supplies getSuppliesById(Integer suppliesId);
}
