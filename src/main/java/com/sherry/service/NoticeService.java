package com.sherry.service;

import com.sherry.mapper.NoticeMapper;
import com.sherry.pojo.Notice;
import com.sherry.vo.DataVo;
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
        System.out.println(notice.getNoticeTitle()+" "+notice.getNoticeContent()+" "+notice.getNoticeCreateTime());
        noticeMapper.insertNotice(notice);
    }
    public Notice selectNoticeById(Integer id){
        return noticeMapper.selectNoticeById(id);
    }

    public void updateNotice(Notice notice){
        System.out.println("Service:"+notice.getNoticeId());
        noticeMapper.updateNotice(notice);
    }
    public DataVo<Notice> listNotices(){
        DataVo<Notice> dataVo = new DataVo<>();
        dataVo.setCode(0);
        dataVo.setCount(getNoticesCount());
        dataVo.setMsg("");
        dataVo.setData(noticeMapper.selectAllNotices());
        return dataVo;
    }
    public void deleteNotice(Integer noticeId){
        noticeMapper.deleteNoticeById(noticeId);
    }
    public Integer getNoticesCount(){
        return noticeMapper.getCount();
    }
}
