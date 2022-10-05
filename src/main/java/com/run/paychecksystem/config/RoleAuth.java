package com.run.paychecksystem.config;

import cn.hutool.http.HttpStatus;
import com.run.paychecksystem.entity.enums.RoleEnum;
import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


/**
 * <pre>RoleAuth</pre>
 *
 * @author <p>ADROITWOLF</p> 2021-06-01
 */
@Aspect
@Component
@Slf4j
public class RoleAuth {

    @Autowired
    TokenService tokenService;

    private static  final  String TOKEN = "Authentication";

    @Pointcut("@annotation(com.run.paychecksystem.config.Role)")
    public void authRole(){

    }

    @Around("authRole() && @annotation(role)")
    public Object auth(ProceedingJoinPoint  joinPoint, Role role) throws Throwable {
        List<RoleEnum> roles = Arrays.asList(role.require());

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String token = request.getHeader(TOKEN);

        List<RoleEnum> needAuth = tokenService.getRoles(token);

        if(verifyAuthority(roles,needAuth)){
            return joinPoint.proceed();
        }else{
            return BaseResponse.builder().status(HttpStatus.HTTP_FORBIDDEN).message("用户没有权限访问").build();
        }
    }

    /**
     * 判断过滤  true表示有权限 ，其实也就是求交集
     * @param roles 访问此接口需要的角色
     * @param needAuth 用户拥有的角色
     * @return
     */
    private boolean verifyAuthority(List<RoleEnum> roles, List<RoleEnum> needAuth) {
        return roles.stream().anyMatch(needAuth::contains);
    }

}
