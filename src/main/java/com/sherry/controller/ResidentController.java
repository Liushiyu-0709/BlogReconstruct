package com.sherry.controller;

import com.sherry.mapper.ResidentSuppliesRefMapper;
import com.sherry.pojo.Resident;
import com.sherry.pojo.ResidentSuppliesRef;
import com.sherry.pojo.Supplies;
import com.sherry.service.ResidentService;
import com.sherry.service.ResidentSuppliesRefService;
import com.sherry.service.SuppliesService;
import com.sherry.vo.ResidentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ResidentController {
    @Autowired
    ResidentService residentService;
    @Autowired
    ResidentSuppliesRefService residentSuppliesRefService;
    @Autowired
    SuppliesService suppliesService;
    @RequestMapping("/resident")
    public String ToResidentView(Model model){
        List<Resident> residentList = residentService.selectAllResidents();
        model.addAttribute("residentList",residentList);
        return "residentView";
    }

    @RequestMapping("/toAddResident")
    public String ToAddView(){
        return "addResident";
    }

    @RequestMapping("/addingResident")
    public String addResident(ResidentVo residentVo){
        Resident resident = new Resident();
        resident.setResidentSex(residentVo.getResidentSex());
        resident.setResidentName(residentVo.getResidentName());
        resident.setResidentAddress(residentVo.getResidentAddress());
        resident.setResidentVisitedDistrict(residentVo.getResidentVisitedDistrict());
        resident.setResidentPhonenumber(residentVo.getResidentPhonenumber());
        resident.setResidentStatus(residentVo.getResidentStatus());
        residentService.insertResident(resident);
        return "redirect:/resident";
    }

    @RequestMapping(value = "/delResident/{residentId}", method = RequestMethod.POST)
    public void DeleteResident(@PathVariable("residentId")Integer residentId){
        residentService.deleteResidentById(residentId);
        residentSuppliesRefService.deleteRecordByResidentId(residentId);
        //先查出该用户所有未领取的供应品
        List<Supplies> suppliesList = residentSuppliesRefService.getSuppliesByCriteria(residentId, false);
        for(Supplies s:suppliesList){
            suppliesService.updateSuppliesCountSituation(s.getSuppliesId());
        }
    }

    @RequestMapping("/toEditResident/{residentId}")
    public String editResident(@PathVariable("residentId")Integer residentId,Model model){
        Resident resident = residentService.getResidentById(residentId);
        model.addAttribute("resident",resident);
        System.out.println("没问题？");
        return "editResident";
    }
    @RequestMapping("/updateResident")
    public String updateResident(ResidentVo residentVo){
        Resident resident = new Resident();
        resident.setResidentId(residentVo.getResidentId());
        resident.setResidentName(residentVo.getResidentName());
        resident.setResidentAddress(residentVo.getResidentAddress());
        resident.setResidentVisitedDistrict(residentVo.getResidentVisitedDistrict());
        resident.setResidentPhonenumber(residentVo.getResidentPhonenumber());
        resident.setResidentStatus(residentVo.getResidentStatus());
        residentService.updateResident(resident);
        return "redirect:/resident";
    }

    @RequestMapping("/getSupplies/{residentId}/{suppliesId}")
    public String getSupplies(@PathVariable("residentId") Integer residentId,@PathVariable("suppliesId") Integer suppliesId){
        //更新居民领取供应品情况记录
        ResidentSuppliesRef record = new ResidentSuppliesRef(residentId,suppliesId,true);
        residentSuppliesRefService.updateRecord(record);
        //更新供应品的未领人数----
        suppliesService.updateSuppliesCountSituation(suppliesId);
        return "redirect:/logining?userId=" + residentId;
    }
}
