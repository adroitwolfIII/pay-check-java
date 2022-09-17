package com.run.paychecksystem.service;

import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.LoginParams;
import lombok.NonNull;

public interface UserService {

    /**
     * 功能描述: 用户登陆
     *
     * @Param: [loginParams]
     * @Return: run.app.entity.DTO.BaseResponse
     * @Author: ADROITWOLF
     * @Date: 2020/1/30 17:52
     */
    @NonNull
    BaseResponse login(@NonNull LoginParams loginParams);
}
