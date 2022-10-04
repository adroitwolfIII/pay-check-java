package com.run.paychecksystem.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>User</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@Table(name = "user")
@Data
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String password;

    private String name;

    private Integer type;

    private String idCard;

    private String creditCard;
}
