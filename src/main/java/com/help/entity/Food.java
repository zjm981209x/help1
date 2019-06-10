package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    /**
     * 外卖id
     */
    private int foodId;
    /**
     * 地址
     */
    private String address;
    /**
     * 食物花费
     */
    private double cost;
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
    private String description;
    /**
     * 约定时间
     */
    private Timestamp time;
}
