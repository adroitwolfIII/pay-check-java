package com.run.paychecksystem.service;

import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.vo.AutoToken;

/**
 * <pre>TokenService</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
public interface TokenService {
    /**
     * 功能描述: 根据用户账号信息构建令牌
     *
     * @Param: [user]
     * @Return: run.app.entity.DTO.AutoToken
     * @Author: WHOAMI
     * @Date: 2020/2/27 21:30
     */
    AutoToken buildAutoToken(User user);
}
