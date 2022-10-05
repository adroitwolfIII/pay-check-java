package com.run.paychecksystem.entity.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <pre>QueryParams</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/8
 */
@Data
@ToString
public class QueryParams {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private String name;



}
