package com.run.paychecksystem.controller;

import com.run.paychecksystem.config.Role;
import com.run.paychecksystem.entity.enums.RoleEnum;
import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.PayParams;
import com.run.paychecksystem.entity.vo.QueryParams;
import com.run.paychecksystem.service.PayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>PayController</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@RequestMapping("pay")
@RestController
public class PayController {


    private static final String TOKEN = "Authentication";

    @Autowired
    PayService payService;

    @Role(require = {RoleEnum.ADMIN})
    @ApiOperation("新增工资")
    @PostMapping("/insert")
    public BaseResponse insert(@RequestBody PayParams payParams){
        return payService.insert(payParams);
    }


    @ApiOperation("用户查询工资")
    @GetMapping("/search")
    public BaseResponse search(HttpServletRequest request,QueryParams queryParams){
        return payService.search(request.getHeader(TOKEN),queryParams);
    }


    @Role(require = {RoleEnum.ADMIN})
    @ApiOperation("管理员查询工资")
    @GetMapping("/search4admin")
    public BaseResponse search4admin(HttpServletRequest request,QueryParams queryParams){
        return payService.search4admin(request.getHeader(TOKEN),queryParams);
    }

}
