package com.run.paychecksystem.controller;

import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.LoginParams;
import com.run.paychecksystem.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <pre>UserController</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户登陆")
    @PostMapping("/login")
    public BaseResponse login(@RequestBody @Valid LoginParams loginParams) {

        return userService.login(loginParams);
    }
}
