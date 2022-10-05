package com.run.paychecksystem.service.impl;

import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.ForgetParams;
import com.run.paychecksystem.entity.vo.LoginParams;
import com.run.paychecksystem.entity.vo.RegisterParams;
import com.run.paychecksystem.exception.BadRequestException;
import com.run.paychecksystem.exception.UnAuthenticationException;
import com.run.paychecksystem.mapper.UserMapper;
import com.run.paychecksystem.service.TokenService;
import com.run.paychecksystem.service.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.List;
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
        Example example = Example.builder(User.class).andWhere(WeekendSqls.<User>custom().andEqualTo(User::getName, loginParams.getP())).build();

        User user = userMapper.selectOneByExample(example);

        if(Objects.isNull(user)){
            throw new BadRequestException("用户账号不存在");
        }

        if(!user.getPassword().equals(loginParams.getPassword())){
            throw new BadRequestException("密码错误");
        }


//        // 暂时只允许管理员登录
//        if (!Integer.valueOf(0).equals(user.getType())){
//
//            throw new BadRequestException("该账号暂时不允许登录");
//        }


        return BaseResponse.success(tokenService.buildAutoToken(user).getAccessToken());
    }

    @Override
    public BaseResponse info(@NonNull String token) {
        Integer id = tokenService.getUserIdByToken(token);

        if (Objects.isNull(id)){
            throw  new UnAuthenticationException("TOKEN错误，请重新登录");
        }

        User user = userMapper.selectByPrimaryKey(id);


        return BaseResponse.success(User.builder().id(user.getId())
                .name(user.getName()).type(user.getType()).build());
    }

    @Override
    public BaseResponse register(@NonNull RegisterParams register) {
        // username变量需要唯一，首先要进行合法性检查
        Example build = Example.builder(User.class).andWhere(WeekendSqls.<User>custom().andEqualTo(User::getName, register.getName())).build();
        List<User> list = userMapper.selectByExample(build);
        if (!list.isEmpty()){
            throw new BadRequestException("该用户名已被注册");
        }


//         只能注册普通用户
        User user = User.builder().type(1).build();

        BeanUtils.copyProperties(register,user);

        userMapper.insertSelective(user);
        // 说明注册失败
        if(Objects.isNull(user.getId())){
            throw new BadRequestException("注册失败");
        }
        return BaseResponse.success("注册成功");
    }

    @Override
    public BaseResponse forget(@NonNull ForgetParams forget) {
        Example example = Example.builder(User.class).andWhere(WeekendSqls.<User>custom().andEqualTo(User::getType, 1).andEqualTo(User::getName,forget.getName()).andEqualTo(User::getIdCard, forget.getIdCard()).andEqualTo(User::getCreditCard, forget.getCreditCard())).build();

        User user = userMapper.selectOneByExample(example);

        if(Objects.isNull(user)){
            throw new BadRequestException("该用户不存在或身份信息不正确，请重试！");
        }

        user.setPassword(forget.getPassword());

        userMapper.updateByPrimaryKey(user);
        return BaseResponse.success("操作成功");
    }
}
