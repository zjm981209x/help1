package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade {
    private int tradeId;
    private String title;
    private double oldPrice;
    private double newPrice;
    private String content;
    private String image;
}
