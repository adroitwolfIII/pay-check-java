package com.run.paychecksystem.entity.vo;

import com.run.paychecksystem.entity.ExcelColumn;
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
    @ExcelColumn(value = "用户账号", col = 1)
    private String name;

    @ExcelColumn(value = "日期", col = 2)
    private Date date;

    @ExcelColumn(value = "基础工资", col = 3)
    private Integer jcgz;

    @ExcelColumn(value = "课时费", col = 4)
    private Integer ksf;

    @ExcelColumn(value = "基础绩效", col = 5)
    private Integer jcjx;

    @ExcelColumn(value = "工龄工资", col = 6)
    private Integer glgz;

    @ExcelColumn(value = "电话补助", col = 7)
    private Integer dhbz;

    @ExcelColumn(value = "交通补助", col = 8)
    private Integer jtbz;

    @ExcelColumn(value = "加班补助", col = 9)
    private Integer jbbz;

    @ExcelColumn(value = "劳动保险", col = 10)
    private Integer ldbx;

    @ExcelColumn(value = "失业保险", col = 11)
    private Integer sybx;

    @ExcelColumn(value = "医疗保险", col = 12)
    private Integer ylbx;

    @ExcelColumn(value = "个人所得税", col = 13)
    private Integer grsds;

    @ExcelColumn(value = "公积金", col = 14)
    private Integer gjj;
}
