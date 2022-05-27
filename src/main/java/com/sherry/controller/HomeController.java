package com.sherry.controller;

import com.sherry.pojo.Notice;
import com.sherry.service.NoticeService;
import com.sherry.vo.DataVo;
import com.sherry.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @RequestMapping("/del/{noticeId}")
    public String DeleteNotice(@PathVariable("noticeId")Integer noticeId){
        noticeService.deleteNotice(noticeId);
        return "redirect:/home";
    }
    //点击新增按钮后跳转到的链接
    @RequestMapping("/toAddNotice")
    public String toAddNotice(){
        return "addNotice";
    }
    @RequestMapping("/addingNotice")
    public String addingNotice(NoticeVO noticeVO) throws ParseException {
        Notice notice = noticeVO.getNotice();
        System.out.println(notice.getNoticeTitle()+" "+notice.getNoticeContent()+" "+notice.getNoticeCreateTime());
        noticeService.insertNotice(notice);
        return "redirect:/home";
    }
    @RequestMapping("/noticeDetail/{noticeId}")
    public String toNoticeDetail(@PathVariable("noticeId") Integer noticeId,Model model){
        Notice notice = noticeService.selectNoticeById(noticeId);
        model.addAttribute("notice",notice);
        return "noticeDetailPage";
    }

    //以下都是测试链接
    @RequestMapping("/test")
    public String test(Model model){
        return "layuitest";
    }
    @ResponseBody
    @RequestMapping("/listNotice")
    public DataVo<Notice> listNoticeData(){
        return noticeService.listNotices();
    }


}
