package com.sherry.vo;

import lombok.Data;

@Data
public class ResidentVo {
    Integer residentId;
    String residentName;
    String residentSex;
    String residentVisitedDistrict;
    String residentAddress;
    String residentPhonenumber;
    //0代表非居民（访客），1代表居民
    Integer residentStatus;
}
