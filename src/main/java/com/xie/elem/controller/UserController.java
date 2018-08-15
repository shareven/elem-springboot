package com.xie.elem.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xie.elem.jpa.model.User;
import com.xie.elem.jpa.repository.UserRepository;
import com.xie.elem.utils.Result;


@Validated
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/checkUsername", produces = "application/json;charset=UTF-8")
	public Result checkUsername(
			@NotNull(message = "用户名不能为空") @Length(min = 2, message = "用户名长度至少为2") @Length(max = 10, message = "用户名长度最大为10") String username) {

		Boolean isExsit = userRepository.existsByUsername(username);
		if (isExsit) {
			return new Result(false, "该用户名不可用");
		}
		return new Result(true, "该用户名可用");
	}

	@RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public Result login(@Valid @RequestBody User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			String err = bindingResult.getAllErrors().toString();
			return new Result(false, err);
		}
		User user1 = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (user1 == null) {
			return new Result(false, "密码错误");
		}
		return new Result(true, "登录成功");
	}

	@RequestMapping(value = "/register", produces = "application/json;charset=UTF-8")
	public Result register(@Validated @RequestBody User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			String err = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new Result(false, err);
		}
		try {
			if (userRepository.existsByUsername(user.getUsername())) {
				return new Result(false, "该用户已存在");
			}
			userRepository.save(user);
			return new Result(true, "注册成功啦");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "注册失败~~" + e.getMessage());
		}
	}

}
