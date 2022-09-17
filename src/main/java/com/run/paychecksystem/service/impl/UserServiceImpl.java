package com.run.paychecksystem.service.impl;

import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.LoginParams;
import com.run.paychecksystem.exception.BadRequestException;
import com.run.paychecksystem.mapper.UserMapper;
import com.run.paychecksystem.service.TokenService;
import com.run.paychecksystem.service.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.Objects;

/**
 * <pre>UserServiceImpl</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TokenService tokenService;

    @Override
    public @NonNull BaseResponse login(@NonNull LoginParams loginParams) {
        Example example = Example.builder(User.class).andWhere(WeekendSqls.<User>custom().andEqualTo(User::getUsername, loginParams.getP())).build();

        User user = userMapper.selectOneByExample(example);

        if(Objects.isNull(user)){
            throw new BadRequestException("用户账号不存在");
        }

        if(!user.getPassword().equals(loginParams.getPassword())){
            throw new BadRequestException("密码错误");
        }


        // 暂时只允许管理员登录
        if (!Integer.valueOf(0).equals(user.getType())){

            throw new BadRequestException("该账号暂时不允许登录");
        }



        return BaseResponse.success(tokenService.buildAutoToken(user).getAccessToken());
    }
}
