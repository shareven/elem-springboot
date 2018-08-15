package com.xie.elem.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * controller 增强器
 */

@ControllerAdvice
public class MyControllerAdvice {
	/*
	 * 全局捕获异常处理
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, Object> errorHandle(Exception ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 101);
		map.put("success", false);
		map.put("msg", ex.getMessage());
		return map;
	}

	/*
	 * 捕获controller中定义校验规则异常处理
	 */
	@ResponseBody
	@ExceptionHandler(value = ConstraintViolationException.class)
	public Map<String, Object> controllerHandle(ConstraintViolationException ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 102);
		map.put("success", false);

		String msg = ex.getMessage();
		msg = msg.substring(msg.indexOf(":") + 2);
		map.put("msg", msg);
		// System.out.println(e.getBindingResult().getAllErrors().get(0).getArguments());
		return map;
	}

	/*
	 * 捕获实体类定义校验规则参数校验异常处理
	 */
	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Map<String, Object> validateHandle(MethodArgumentNotValidException ex) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 103);
		map.put("success", false);
		String msg = "";
		// ex.printStackTrace();
		BindingResult br = ex.getBindingResult();
		List<ObjectError> errors = br.getAllErrors();
		for (ObjectError or : errors) {
			msg = msg + or.getDefaultMessage() + ";";
		}
		map.put("msg", msg);

		return map;
	}

	/*
	 * 捕获自定义异常
	 * 
	 */
	@ResponseBody
	@ExceptionHandler(value = MyException.class)
	public Map<String, Object> errorHandle(MyException ex) {
		Map map = new HashMap<String, Object>();
		map.put("code", ex.getCode());
		map.put("success", ex.getSuccess());
		map.put("msg", ex.getMsg());
		return map;
	}
}
