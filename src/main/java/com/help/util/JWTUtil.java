package com.help.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtil {
    public static String getToken(String name){
        Date date = new Date(System.currentTimeMillis() + 15*60*1000);
        String token = Jwts.builder()
                .claim("username",name)
                .signWith(SignatureAlgorithm.HS256,"myjwtsecret")
                .setExpiration(date)
                .compact();
        return token;
    }

}
