package com.run.paychecksystem.service.impl;

import com.auth0.jwt.JWT;
import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.enums.RoleEnum;
import com.run.paychecksystem.entity.vo.AutoToken;
import com.run.paychecksystem.service.JwtService;
import com.run.paychecksystem.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <pre>TokenServiceImpl</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    JwtService jwtService;

    @Override
    public AutoToken buildAutoToken(User user) {
        RoleEnum role = user.getType().equals(0)?RoleEnum.ADMIN:RoleEnum.USER;
        return AutoToken.builder().accessToken(jwtService.generateToken(user,role)).build();
    }


    @Override
    public Integer getUserIdByToken(String token) {

        return JWT.decode(token).getClaim("userId").asInt();

    }


    @Override
    public List<RoleEnum> getRoles(String token) {
        return jwtService.generateRole(token);
    }

}
