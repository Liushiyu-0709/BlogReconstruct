package com.sherry.vo;

import com.sherry.pojo.Notice;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//用于获取新增通告页面的参数
@Data
public class NoticeVO {
    private String noticeTitle;
    private String noticeContent;
    private String noticeCreateTime;
    public Notice getNotice() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(noticeCreateTime);
        Notice notice = new Notice(noticeTitle,noticeContent,date);
        return notice;
    }
}
