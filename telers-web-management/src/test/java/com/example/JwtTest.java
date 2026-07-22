package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    /*
    生成jwt令牌
     */
    public void testJwt(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","Tr");
        String compact = Jwts.builder().signWith(SignatureAlgorithm.HS256,"VHI=").addClaims(dataMap).setExpiration(new Date(System.currentTimeMillis()+3600*1000)).compact();
        System.out.println(compact);
    }
    @Test
    /*
    解析JWT
     */
    public void testJwt1(){
       String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJUciIsImV4cCI6MTc4NDYxOTcxNX0.Ze_MKF0DW8VJ0sWT5Rnnl4w69umX9nPPPo_HqgtbqVw";
       Claims claims = Jwts.parser().setSigningKey("VHI=").parseClaimsJws(token).getBody();
        System.out.println(claims);
    }
}
