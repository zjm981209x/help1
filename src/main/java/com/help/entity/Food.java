package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    private int foodId;
    private String address;
    private double cost;
    private double pay;
    private String phone;
    private String description;
    private Timestamp time;
}
