package com.imooc.zhou.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局同一异常处理
 * @author zhouw
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", false);
		map.put("errMsg", e.getMessage());
		return map;
	}
}
