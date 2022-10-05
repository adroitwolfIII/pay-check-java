package com.run.paychecksystem.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.run.paychecksystem.config.JWTProperties;
import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.enums.RoleEnum;
import com.run.paychecksystem.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>JwtServiceImpl</pre>
 *
 * @author <p>ADROITWOLF</p> 2021-05-07
 */
@Service("authJwtService")
@Slf4j
public class JwtServiceImpl implements JwtService {
    @Autowired
    JWTProperties jwtProperties;


    @Override
    public String generateToken(User user,RoleEnum role) {
        long currentTimeMillis = System.currentTimeMillis();
        return JWT.create()
                .withIssuer(jwtProperties.getName())
                .withExpiresAt(new Date(currentTimeMillis + jwtProperties.getJwtExpires() * 1000*24*3600))
                .withClaim("userId", user.getId())
                .withClaim("role",role.getAuthority())
                .withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(jwtProperties.getBase64Secret()));
    }

    @Override
    public  JWTVerifier generateVerifier() {
        return JWT.require(Algorithm.HMAC256(jwtProperties.getBase64Secret()))
                .withIssuer(jwtProperties.getName())
                .build();
    }

    @Override
    public Date generateExpirationDate(String token) {
        return JWT.decode(token).getExpiresAt();
    }

    @Override
    public List<RoleEnum> generateRole(String token) {
        List<RoleEnum> res = new ArrayList<>();
        res.add(JWT.decode(token).getClaim("role").as(RoleEnum.class));
        return res;
    }

}
