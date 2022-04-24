package com.sherry.mapper;

import com.sherry.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    public List<Notice> selectAllNotices();
    public List<Notice> selectNoticesByLimit(@Param(value="limit") Integer limit);
    public Notice selectNoticeById(@Param(value="noticeId") Integer noticeId);
    public Integer updateNotice(Notice notice);
    public void deleteNoticeById(@Param(value="noticeId") Integer noticeId);
    public void insertNotice(@Param(value="notice") Notice notice);


}
