package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade {
    /**
     * 交易id
     */
    private int tradeId;
    /**
     * 标题
     */
    private String title;
    /**
     * 物品原价
     */
    private double oldPrice;
    /**
     * 交易价格
     */
    private double newPrice;
    /**
     * 其他描述
     */
    private String content;
    /**
     * 物品图片
     */
    private String image;
}
