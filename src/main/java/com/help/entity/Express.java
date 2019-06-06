package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Express {
    private int expressId;
    private String address;
    private double pay;
    private String phone;
    private String content;
    private Timestamp time;
}
