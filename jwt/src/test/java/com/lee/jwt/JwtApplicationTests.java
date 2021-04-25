package com.lee.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("21");
    }

    /**
     * 生成令牌
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void createJsonWebToken() throws UnsupportedEncodingException {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 3600);
        HashMap<String, Object> headerMap = new HashMap<>();
        Integer[] ints = {12, 3};
        String sign = JWT.create()
                .withHeader(headerMap)
                .withClaim("username", "zhangsan")
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("token!@!$#&*DA"));
        System.out.println(sign);
    }

    @Test
    public void signJsonToken() throws UnsupportedEncodingException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("token!@!$#&*DA")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTM2NDA5MjUsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.Il5bq5A4eW8tJIBj5x5ctFe-6wPi8LtAZBxrpkNsSzQ");
        System.out.println(verify.getClaim("username").asString());
    }

}
