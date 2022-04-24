package com.sherry.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("Notice")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notice {
    private int noticeId;
    private String noticeTitle;
    private String noticeContent;
    private Date noticeCreateTime;
}
