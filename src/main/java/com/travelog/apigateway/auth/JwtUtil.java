//package com.travelog.apigateway.auth;
//
//import io.jsonwebtoken.Jwts;
//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.Base64;
//import java.util.Date;
//
//@Slf4j
//@Service
//public class JwtUtil {
//
//    private String secretKey = "secretKey";
//
//    // 객체 초기화, secretKey를 Base64로 인코딩
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    public boolean validateToken(String jwtToken) {
//        try {
//            Date now = new Date();
//            Date exp = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody().getExpiration();
//            return now.before(exp);
//        } catch (Exception e) {
//            log.error("error={}", e.getMessage());
//            return false;
//        }
//    }
//}
