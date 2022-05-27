package com.sherry.blogreconstruct;

import com.sherry.mapper.ResidentMapper;
import com.sherry.mapper.ResidentSuppliesRefMapper;
import com.sherry.pojo.Resident;
import com.sherry.pojo.Supplies;
import com.sherry.service.ResidentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogReconstructApplicationTests {
    @Autowired
    ResidentService residentService;
    @Autowired
    ResidentMapper residentMapper;
    @Autowired
    ResidentSuppliesRefMapper residentSuppliesRefMapper;
    @Test
    void contextLoads() {

        residentService.selectAllResidents();
        Resident r = new Resident();
        r.setResidentId(1);
        r.setResidentName("刘诗雨");
        r.setResidentAddress("西财小区10栋1单元");
        r.setResidentSex("女");
        r.setResidentPhonenumber("18708418129");
        r.setResidentVisitedDistrict("低风险");
//        residentService.updateResident(r);
        Resident r2 = r;
        r.setResidentId(null);
        r.setResidentSex("男");
        r.setResidentName("呵呵呵");
        //测试插入
        residentService.insertResident(r2);
        //测试查询
        residentService.selectAllResidents();
    }
    @Test
    void testResident(){
        //测试删除
        residentService.deleteResidentById(3);
    }
    @Test 
    void testResidentSuppliesRef(){
        List<Resident> residentIdsByCriteria = residentSuppliesRefMapper.getResidentsByCriteria(1, true);
        for(Resident r:residentIdsByCriteria){
            System.out.println(r);
        }
        List<Supplies> suppliesList = residentSuppliesRefMapper.getSuppliesByCriteria(1,false);
        //一号居民未领取
        for(Supplies s:suppliesList){
            System.out.println(s.getSuppliesId());
        }
    }

}
