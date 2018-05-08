package com.ccnu.xiahongyun.stmanagementsystem.query;

import java.util.Date;

public class CheckInInfo {
    private String UserName;

    /*身份证*/
    private String userIDNum;

    private String phone;

    /*开始入住时间*/
    private Date timeBegin;

    /* 结束时间  */
    private Date timeEnd;

    /*游泳池套餐数量*/
    private Integer swimming;

    /*健生房套餐数量*/
    private Integer gym;

    /*免费酒水权限*/
    private Boolean freeDinks;

    /*住房总费用*/
    private Double totPrice;

    private Integer roomId;

    private Integer userId;
}
