package com.run.paychecksystem.service;

import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.enums.RoleEnum;
import com.run.paychecksystem.entity.vo.AutoToken;

import java.util.List;

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


    /**
     * 功能描述: 根据access_token令牌获取角色id
     * @Author: WHOAMI
     * @Date: 2020/1/30 17:58
     */
    Integer getUserIdByToken(String token);


    /**
     * 功能描述: 获取当前用户的角色
     *
     * @Param: [token]
     * @Return: java.util.List<run.app.entity.enums.RoleEnum>
     * @Author: WHOAMI
     * @Date: 2020/1/30 17:57
     */
    List<RoleEnum> getRoles(String token);
}
