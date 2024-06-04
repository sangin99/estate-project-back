// JWT 생성자 만들기
package com.estate.back.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// Jwt 생성 및 검증 기능 제공자
// - jwt 암호와 알고리즘 HS256
// - 비밀키는 환경변수에 있는 jwt.secret-key
// - jwt 만료 기간 10시간
// TODO (이후 1시간)

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    
    @Value("${jwt.secret-key}")
    private String secretKey;

    // Jwt 생성 메서드
    public String create (String userId) {

        // 만료시간 = 현재시간 + 10시간
        Date expiredDate = Date.from(Instant.now().plus(10, ChronoUnit.HOURS));

        String jwt = null;
  
        try {
            Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
                    
            jwt = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .compact();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        
        return jwt;
    }

    // Jwt 검증 메서드
    public String validate (String jwt) {

        String userId = null;  // 반환할 변수만들기
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        try{
            userId = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)  // 해체
                .getBody()  // 바디 값 가져오기
                .getSubject();   // Sub.. 가져오기
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return userId;
    }
}
