package com.sherry.service;

import com.sherry.mapper.NoticeMapper;
import com.sherry.pojo.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    public List<Notice> selectAllNotices(){
        return noticeMapper.selectAllNotices();
    }
    public void insertNotice(Notice notice){
        noticeMapper.insertNotice(notice);
    }
    public Notice selectNoticeById(Integer id){
        return noticeMapper.selectNoticeById(id);
    }
    public void updateNotice(Notice notice){
        System.out.println("Service:"+notice.getNoticeId());
        noticeMapper.updateNotice(notice);
    }
}
