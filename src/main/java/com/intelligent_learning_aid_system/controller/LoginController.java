package com.intelligent_learning_aid_system.controller;

import com.intelligent_learning_aid_system.pojo.Emp;
import com.intelligent_learning_aid_system.pojo.Result;
import com.intelligent_learning_aid_system.service.EmpService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录成功 {}",emp);
        Emp e = empService.login(emp);

        // 登录成功，发放令牌
        if( e != null) {
            // 生成令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", e.getUsername());
            claims.put("role", "admin");
            String jwts = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256,"gdlm") // 签名算法
                    .setClaims(claims) // 自定义数据（载荷）
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 设置过期时间
                    .compact();
            return Result.success(jwts);
        }
        return  Result.error("用户名或密码错误");
    }
}
