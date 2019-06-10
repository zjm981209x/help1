package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户id
     */
    private int userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPw;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户联系方式
     */
    private String phone;
    /**
     * 用户头像
     */
    private String image;
    /**
     * 用户邮箱
     */
    private String email;

}
