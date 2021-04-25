package com.lee.jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Map;

/**
 * @author lee
 * @version 1.0
 * @date 2021/2/18
 */
public class JWTUtils {

    private static final String SIGN = "~!Q@W#E$R%T^Y&~";


    /**
     * createToken
     *
     * @param map map
     * @return token
     * @throws UnsupportedEncodingException exception
     */
    public static String getToken(Map<String, Object> map) throws UnsupportedEncodingException {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 1);

        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v.toString());
        });

        return builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SIGN));
    }


    /**
     * verifyToken
     *
     * @param token token
     * @throws UnsupportedEncodingException exception
     */
    public static void verifyToken(String token) throws UnsupportedEncodingException {
    }
}
