package com.gj.demo.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gj.demo.base.ResponseResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler
	public ResponseResult<Object> processException(Exception ex, HttpServletRequest request, HttpServletResponse response){
		LOGGER.error("有异常：",ex);
		
		if(ex instanceof MissingServletRequestParameterException){
			return new ResponseResult<Object>(400, ex.getMessage(), null);
		}
		
		return new ResponseResult<Object>(500, ex.getMessage(), null);
		
	}
}
