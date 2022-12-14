package com.run.paychecksystem.service;

import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.PayParams;
import com.run.paychecksystem.entity.vo.QueryParams;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <pre>PayService</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
public interface PayService {
    BaseResponse insert(PayParams payParams);


    BaseResponse search(String token,QueryParams queryParams);


    BaseResponse search4admin(String token,QueryParams queryParams);



    BaseResponse delItem(Integer id);

    BaseResponse importExcel(MultipartFile file);

}
