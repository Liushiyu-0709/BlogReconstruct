package com.sherry.controller;

import com.sherry.pojo.Notice;
import com.sherry.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

public class HomeController {
    @Autowired
    NoticeService noticeService;
    @RequestMapping("/home")
    public String HomeView(Model model){
        List<Notice> noticeList = noticeService.selectAllNotices();
        model.addAttribute("noticeList",noticeList);
        return "hello";
    }
    @RequestMapping("/edit/{noticeId}")
    public String toEditPage(@PathVariable("noticeId")Integer noticeId,Model model){
        Notice notice = noticeService.selectNoticeById(noticeId);
        model.addAttribute("notice",notice);
        return "editNotice";
    }
    @RequestMapping("/editNotice")
    public String EditNotice(@ModelAttribute Notice notice){
        System.out.println(notice.getNoticeId());
        noticeService.updateNotice(notice);
        return "redirect:/home";
    }
}
