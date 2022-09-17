package com.run.paychecksystem.controller.base;


import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <pre>HandlerExceptionController</pre>
 *
 * @author <p>ADROITWOLF</p> 2021-05-09
 */
@RestControllerAdvice
@Slf4j
public class HandlerExceptionController {
    @ExceptionHandler(AppException.class)
    public BaseResponse handlerBlogException(AppException e) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(e.getStatus().value());
        baseResponse.setMessage(e.getMessage());
        baseResponse.setData(e.getErrorData());
        return baseResponse;
    }


    //
//    @ExceptionHandler(BadRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public BaseResponse handlerBadException(BadRequestException e){
//        BaseResponse baseResponse = new BaseResponse();
//
//        baseResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//
//        baseResponse.setMessage(e.getMessage());
//
//        return baseResponse;
//
//    }
//
//
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BaseResponse baseResponse = new BaseResponse();

        baseResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        log.debug(e.getBindingResult().getAllErrors().toString());

        baseResponse.setMessage("字段验证错误，请重试！");

        return baseResponse;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse handlerIllegalArgumentException(IllegalArgumentException e) {
        BaseResponse baseResponse = new BaseResponse();

        baseResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        log.debug(e.getMessage());

        baseResponse.setMessage("请不要尝试注入非法字符");

        return baseResponse;
    }

//
//
//
//    @ExceptionHandler(UnAuthenticationException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public BaseResponse handlerUnAuthenticationException(UnAuthenticationException e){
//        BaseResponse baseResponse = new BaseResponse();
//
//        baseResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
//
//        log.debug(e.getMessage());
//
//        baseResponse.setMessage(e.getMessage());
//
//        return  baseResponse;
//    }
//
//    @ExceptionHandler(ServiceException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public BaseResponse handlerServiceException(ServiceException e){
//        BaseResponse baseResponse = new BaseResponse();
//
//        baseResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//
//        log.debug(e.getMessage());
//
//        baseResponse.setMessage(e.getMessage());
//
//        return  baseResponse;
//    }
//
//    @ExceptionHandler(UnAccessException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public BaseResponse handlerUnAccessException(UnAccessException e){
//        BaseResponse baseResponse = new BaseResponse();
//
//        baseResponse.setStatus(HttpStatus.FORBIDDEN.value());
//
//        log.debug(e.getMessage());
//
//        baseResponse.setMessage(e.getMessage());
//
//        return  baseResponse;
//    }
}
