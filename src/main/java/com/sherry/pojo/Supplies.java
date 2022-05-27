package com.sherry.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Supplies {
    Integer suppliesId;
    String suppliesContent;
    //物资介绍
    String suppliesIntroduction;
    //未领取人数
    Integer remainCount;
    //已领取人数
    Integer distributeCount;
    //物资数量
    Integer suppliesAmount;
    //领取者Id
    List<Integer> hasGetResidents;
    //未领取者Id
    List<Integer> notGetResidents;
}
