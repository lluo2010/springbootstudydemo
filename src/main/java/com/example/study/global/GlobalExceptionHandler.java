package com.example.study.global;

import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by louis on 2018/9/6.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {


    /*@Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppResponse handle(ValidationException exception) {
        System.out.println("bad request, " + exception.getMessage());
        String strErrorMsg = "bad request: " + exception.getMessage();
        return new AppResponse(-1, strErrorMsg);
    }*/




   /**
     * 对应@Valid验证产生的错误
     * @param exception
     * @return
     */
    /*@ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppResponse handle(MethodArgumentNotValidException exception) {
*//*        exception.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());*//*
        String defaultMessage = exception.getBindingResult().getFieldError().getDefaultMessage();
        return new AppResponse(-1, defaultMessage);

    }*/


    /**
     * 对应@Validated验证产生的错误
     * @param exception
     * @return
     */
    /*@ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppResponse handle(ConstraintViolationException exception) {
        List<String> errorList = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        String errorMsg = String.join(",", errorList);
        return new AppResponse(-1, errorMsg);
    }*/
}
