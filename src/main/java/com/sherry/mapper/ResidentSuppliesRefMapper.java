package com.sherry.mapper;

import com.sherry.pojo.Resident;
import com.sherry.pojo.ResidentSuppliesRef;
import com.sherry.pojo.Supplies;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResidentSuppliesRefMapper {
    Integer insertRecord(ResidentSuppliesRef residentSuppliesRef);
    Integer updateRecord(ResidentSuppliesRef residentSuppliesRef);
    List<Resident> getResidentsByCriteria(Integer suppliesId, boolean getSituation);
    List<Supplies> getSuppliesByCriteria(Integer residentId, boolean getSituation);
    //当一位居民被移除时，要删掉他的供应物记录
    Integer deleteRecordByResidentId(Integer residentId);
    //当一个物资移除的时候，删除对应居民未领物品的记录
    Integer deleteRecordBySuppliesId(Integer suppliesId);
}
