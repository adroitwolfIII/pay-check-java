package com.run.paychecksystem.entity.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * <pre>payParams</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@Data
@ToString
public class PayParams {

    private String name;

    private Date date;

    private Integer jcgz;

    private Integer ksf;

    private Integer jcjx;

    private Integer glgz;

    private Integer dhbz;

    private Integer jtbz;

    private Integer jbbz;

    private Integer ldbx;

    private Integer sybx;

    private Integer ylbx;

    private Integer grsds;
}
