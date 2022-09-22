package com.run.paychecksystem.service;

import com.auth0.jwt.JWTVerifier;
import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.enums.RoleEnum;

import java.util.Date;
import java.util.List;

/**
 * <pre>JwtService</pre>
 *
 * @author <p>ADROITWOLF</p> 2021-05-07
 */
public interface JwtService {
    /**
     * 生成token令牌
     * @param user
     * @return
     */
    String generateToken(User user,RoleEnum role);

    JWTVerifier generateVerifier();

    Date generateExpirationDate(String token);

    RoleEnum generateRole(String token);
}
