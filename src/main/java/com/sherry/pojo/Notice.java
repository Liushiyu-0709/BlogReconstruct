package com.sherry.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.text.SimpleDateFormat;
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

    public Notice(String noticeTitle, String noticeContent, Date noticeCreateTime) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeCreateTime = noticeCreateTime;
    }
    public String getStrCreateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(noticeCreateTime);
    }
    public String getThumbnail(){
        if(noticeContent.length()<=50){
            return noticeContent;
        }else{
            String thumbnail = noticeContent.substring(0,50);
            thumbnail += "...";
            return thumbnail;
        }
    }
}
