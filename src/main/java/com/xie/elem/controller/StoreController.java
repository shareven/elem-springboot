package com.xie.elem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xie.elem.jpa.model.Store;
import com.xie.elem.jpa.repository.StoreRepository;
import com.xie.elem.utils.Result;

@Validated
@RestController
public class StoreController {
	@Autowired
	StoreRepository storeRepository;
	
	@RequestMapping(value = "/test")
	public List<Store> test() {
		return storeRepository.findAll();
	}

	@RequestMapping(value = "/addStore", produces = "application/json;charset=UTF-8")
	public Result addStore(@Validated @RequestBody Store store, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			String err = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new Result(false, err);
		}
		try {
			if (storeRepository.existsByName(store.getName())) {
				return new Result(false, "该店名已存在");
			}
			storeRepository.save(store);
			return new Result(true, "注册成功啦");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "注册失败~~" + e.getMessage());
		}
	}
	
}
