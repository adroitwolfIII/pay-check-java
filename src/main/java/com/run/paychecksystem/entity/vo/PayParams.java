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

    private String title;

    private Integer value;
}
