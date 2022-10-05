package com.run.paychecksystem.entity.vo;


import lombok.Data;
import lombok.ToString;

/**
 * 忘记密码前端
 */
@Data
@ToString
public class ForgetParams {

    private String name;

    private String password;

    private String idCard;

    private String creditCard;
}
