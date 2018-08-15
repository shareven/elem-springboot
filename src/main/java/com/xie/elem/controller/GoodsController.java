package com.xie.elem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xie.elem.jpa.model.Goods;
import com.xie.elem.jpa.repository.GoodsRepository;
import com.xie.elem.utils.Result;

@Validated
@RestController
public class GoodsController {

	@Autowired
	GoodsRepository goodsRepository;

	@RequestMapping(value = "/addGoods", produces = "application/json;charset=UTF-8")
	public Result register(@Validated @RequestBody Goods goods, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			String err = bindingResult.getAllErrors().get(0).getDefaultMessage();
			return new Result(false, err);
		}
		try {
			if (goodsRepository.existsByName(goods.getName())) {
				return new Result(false, "该商品已存在");
			}
			goodsRepository.save(goods);
			return new Result(true, "添加商品成功啦");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "添加商品失败~~" + e.getMessage());
		}
	}
}
