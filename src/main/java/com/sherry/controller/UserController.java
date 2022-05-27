package com.sherry.controller;

import com.sherry.mapper.ResidentSuppliesRefMapper;
import com.sherry.pojo.Notice;
import com.sherry.pojo.Resident;
import com.sherry.pojo.Supplies;
import com.sherry.service.NoticeService;
import com.sherry.service.ResidentService;
import com.sherry.service.ResidentSuppliesRefService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

//为了用户界面设置的控制器
@Controller
public class UserController {
    @Autowired
    ResidentSuppliesRefService residentSuppliesRefService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    ResidentService residentService;
    @RequestMapping("/")
    public String toLogin(){
        return "userView/userLogin";
    }
    @RequestMapping("/logining")
    public String toView(@Param("userId") String userId, Model model){
        System.out.println(userId);
        if(Objects.equals(userId, "admin")) return "redirect:/home";
        //若不是管理员，说明是普通居民
        Resident resident = residentService.getResidentById(Integer.parseInt(userId));
        model.addAttribute("residentName",resident.getResidentName());
        model.addAttribute("residentId",resident.getResidentId());
        List<Supplies> hasGetSuppliesList = residentSuppliesRefService.getSuppliesByCriteria(Integer.parseInt(userId),true);
        model.addAttribute("hasGetSuppliesList",hasGetSuppliesList);
        List<Supplies> notGetSuppliesList = residentSuppliesRefService.getSuppliesByCriteria(Integer.parseInt(userId),false);
        model.addAttribute("notGetSuppliesList",notGetSuppliesList);
        List<Notice> noticeList = noticeService.selectAllNotices();
        model.addAttribute("noticeList",noticeList);
        return "userView/userView";
    }

    @RequestMapping("/teamShow")
    public String teamShow(){
        return "userView/teamShow";
    }
}
