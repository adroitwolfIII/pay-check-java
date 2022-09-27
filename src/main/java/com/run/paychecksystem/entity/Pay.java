package com.run.paychecksystem.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <pre>Pay</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@Data
@ToString
@Builder
@Table(name = "pay")
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dateTime;

    private Integer userId;

    private Integer jcgz = 0 ;

    private Integer ksf = 0;

    private Integer jcjx = 0;

    private Integer glgz = 0;

    private Integer dhbz = 0;

    private Integer jtbz = 0;

    private Integer jbbz = 0;

    private Integer ldbx = 0;

    private Integer sybx = 0;

    private Integer ylbx = 0;

    private Integer grsds = 0;

    private Integer gjj = 0;
}
