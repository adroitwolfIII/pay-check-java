package com.run.paychecksystem.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time:2019/6/27
 * Description:过滤器配置
 */
@Slf4j
@Configuration
public class FilterConfiguration {


    @Bean
    public FilterRegistrationBean<CorsFilter> initCorsFilter() {
        FilterRegistrationBean<CorsFilter> corsFilter = new FilterRegistrationBean<>();

        corsFilter.setOrder(Ordered.LOWEST_PRECEDENCE);
        corsFilter.setFilter(new CorsFilter());

        corsFilter.addUrlPatterns("/*");

        return corsFilter;
    }
//
//
//    @Bean
//    public FilterRegistrationBean<AuthenticationFilter> initAuthenticationFilter(TokenService tokenService) {
//
//
//        FilterRegistrationBean<AuthenticationFilter> authenticationFilterFilter = new FilterRegistrationBean<>();
//        AuthenticationFilter authenticationFilter = new AuthenticationFilter(tokenService);
//
////        添加不拦截路径
//        authenticationFilter.addExcludePatterns("/api/admin/login", "/api/admin/register", "/api/post/**", "/api/admin/refresh/**", "/api/admin/getMailCode/**");
//
//
////        添加拦截角色路径
//        Map<RoleEnum, List<String>> pattern = new HashMap<RoleEnum, List<String>>() {
//            {
//                put(RoleEnum.USER, Arrays.asList("/api/**/*"));
//                put(RoleEnum.ADMIN, Arrays.asList("/manage/**/*"));
//            }
//        };
//
//        authenticationFilter.addAuthorityPatterns(pattern);
//
//        authenticationFilterFilter.setFilter(authenticationFilter);
//
//        authenticationFilterFilter.setOrder(Ordered.LOWEST_PRECEDENCE);
//
//        authenticationFilterFilter.addUrlPatterns("/api/*", "/manage/*");
//
//        return authenticationFilterFilter;
//    }


}
