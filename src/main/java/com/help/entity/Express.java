package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Express {
    /**
     * 快递id
     */
    private int expressId;
    /**
     * 地址
     */
    private String address;
    /**
     * 酬劳
     */
    private double pay;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 其他备注
     */
    private String content;
    /**
     * 约定时间
     */
    private Timestamp time;
}
