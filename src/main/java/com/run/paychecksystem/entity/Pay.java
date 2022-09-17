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

    private String title;

    private Integer value;
}
