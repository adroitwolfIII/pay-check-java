package com.run.paychecksystem.controller;

import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.LoginParams;
import com.run.paychecksystem.entity.vo.RegisterParams;
import com.run.paychecksystem.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <pre>UserController</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final String TOKEN = "Authentication";

    @Autowired
    UserService userService;

    @ApiOperation("用户登陆")
    @PostMapping("/login")
    public BaseResponse login(@RequestBody @Valid LoginParams loginParams) {

        return userService.login(loginParams);
    }

    @ApiOperation("获得用户信息")
    @GetMapping("/info")
    public BaseResponse info(HttpServletRequest request) {

        return userService.info(request.getHeader(TOKEN));
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public BaseResponse register(@RequestBody RegisterParams registerParams) {

        return userService.register(registerParams);
    }



}
