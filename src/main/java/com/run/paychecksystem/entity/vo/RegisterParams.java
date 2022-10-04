package com.run.paychecksystem.entity.vo;

import lombok.Data;
import lombok.ToString;

/**
 * <pre>RegisterParams</pre>
 * 注册信息前端变量
 * @author <p>ADROITWOLF</p> 2022/10/4
 */
@Data
@ToString
public class RegisterParams {
    private String name;

    private String password;

    private String idCard;

    private String creditCard;
}
