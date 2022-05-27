package com.sherry.controller;

import com.sherry.pojo.Resident;
import com.sherry.pojo.Supplies;
import com.sherry.service.ResidentService;
import com.sherry.service.ResidentSuppliesRefService;
import com.sherry.service.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SuppliesController {
    @Autowired
    SuppliesService suppliesService;
    @Autowired
    ResidentService residentService;
    @Autowired
    ResidentSuppliesRefService residentSuppliesRefService;
    @RequestMapping("/supplies")
    public String TosuppliesView(Model model){
        List<Supplies> suppliesList = suppliesService.selectAllSupplies();
        model.addAttribute("suppliesList",suppliesList);
        return "suppliesView";
    }
    @RequestMapping("/toAddSupplies")
    public String toAddSupplies(){
        return "addSupplies";
    }

    @RequestMapping("/addSupplies")
    public String addSupplies(String suppliesContent,String suppliesIntroduction,Integer suppliesAmount){
        Supplies s = new Supplies();
        s.setSuppliesContent(suppliesContent);
        s.setSuppliesIntroduction(suppliesIntroduction);
        s.setSuppliesAmount(suppliesAmount);
        int residentCount = residentService.getResidentCount();
        s.setDistributeCount(0);
        //设置所有居民未领取
        s.setRemainCount(residentCount);
        suppliesService.addSupplies(s);
        return "redirect:/supplies";
    }
    @RequestMapping(value = "/delSupplies/{suppliesId}", method = RequestMethod.POST)
    public void DeleteSupplies (@PathVariable("suppliesId")Integer suppliesId){
        suppliesService.deleteSuppliesById(suppliesId);
        residentSuppliesRefService.deleteRecordBySuppliesId(suppliesId);
    }

    @RequestMapping("/showSupplies/{suppliesId}")
    public String showUnreceviedResident(@PathVariable("suppliesId") Integer suppliesId,Model model){
        //查看该供应品的未领取人群
        List<Resident> unReceivedResidentList = residentSuppliesRefService.getResidentsByCriteria(suppliesId, false);
        model.addAttribute("unResidentList",unReceivedResidentList);
        return "SuppliesReceiveShow";
    }
}
