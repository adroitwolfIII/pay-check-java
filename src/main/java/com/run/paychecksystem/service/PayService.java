package com.run.paychecksystem.service;

import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.PayParams;
import com.run.paychecksystem.entity.vo.QueryParams;

/**
 * <pre>PayService</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
public interface PayService {
    BaseResponse insert(PayParams payParams);

    BaseResponse search(String token,QueryParams queryParams);
}
