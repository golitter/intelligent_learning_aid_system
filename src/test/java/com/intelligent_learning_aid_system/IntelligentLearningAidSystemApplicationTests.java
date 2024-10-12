package com.intelligent_learning_aid_system;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class IntelligentLearningAidSystemApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "glm");
        claims.put("role", "admin");
        String jwts = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"gdlm") // 签名算法
                .setClaims(claims) // 自定义数据（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 设置过期时间
                .compact();
        System.out.println(jwts);

        claims = Jwts.parser()
                .setSigningKey("gdlm")
                .parseClaimsJws(jwts)
                .getBody();
        System.out.println(claims);
    }

}
