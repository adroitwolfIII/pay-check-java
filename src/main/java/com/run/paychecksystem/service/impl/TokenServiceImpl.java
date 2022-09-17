package com.run.paychecksystem.service.impl;

import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.vo.AutoToken;
import com.run.paychecksystem.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <pre>TokenServiceImpl</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@Service
public class TokenServiceImpl implements TokenService {


    @Override
    public AutoToken buildAutoToken(User user) {
//    暂时使用UUID来生成token
        return AutoToken.builder().accessToken(UUID.randomUUID().toString().replaceAll("-","")).build();
    }
}
