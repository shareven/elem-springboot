package com.xie.elem.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "goods")
public class Goods {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@NotBlank(message = "商品名不能为空")
	@Length(min = 2, message = "商品名长度至少为2")
	@Length(max = 10, message = "商品名长度最大为20")
	@Size(min = 2, max = 10)
	@Column(name = "name", nullable = false)
	private String name;

	private String image;

	private Integer sellCount;
	private Integer rating;
	private Integer oldPrice;
	private Integer price;
	private String description;

	private String info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getSellCount() {
		return sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Integer oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
