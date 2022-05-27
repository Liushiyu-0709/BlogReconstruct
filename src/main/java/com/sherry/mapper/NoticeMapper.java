package com.sherry.mapper;

import com.sherry.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> selectAllNotices();
    List<Notice> selectNoticesByLimit(@Param(value="limit") Integer limit);
    Notice selectNoticeById(@Param(value="noticeId") Integer noticeId);
    Integer updateNotice(Notice notice);
    void deleteNoticeById(@Param(value="noticeId") Integer noticeId);
    Integer insertNotice(Notice notice);
    Integer getCount();

}
