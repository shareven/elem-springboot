package com.xie.elem.jpa.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * 实体类商店
 * 
 * @author xie
 *
 */
@Entity
@Table(name = "store")
public class Store implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id" ,nullable = false)
	private long id;
	
	@NotBlank(message = "店名不能为空")
	@Length(min = 2, message = "店名长度至少为2")
	@Length(max = 10, message = "店名长度最大为20")
	@Size(min = 2, max = 10)
	@Column(name="name" ,nullable = false)
	private String name;
	

	private String store_cover_url;
	

	private String store_notice;
	

	private String store_starting_price;
	

	private String store_delivery_price;
	

	private String store_avg_time;
	

	private String store_images_url;
	

	private String store_type_name;
	

	private String store_address;
	

	private String store_business_hour;

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

	public String getStore_cover_url() {
		return store_cover_url;
	}

	public void setStore_cover_url(String store_cover_url) {
		this.store_cover_url = store_cover_url;
	}

	public String getStore_notice() {
		return store_notice;
	}

	public void setStore_notice(String store_notice) {
		this.store_notice = store_notice;
	}

	public String getStore_starting_price() {
		return store_starting_price;
	}

	public void setStore_starting_price(String store_starting_price) {
		this.store_starting_price = store_starting_price;
	}

	public String getStore_delivery_price() {
		return store_delivery_price;
	}

	public void setStore_delivery_price(String store_delivery_price) {
		this.store_delivery_price = store_delivery_price;
	}

	public String getStore_avg_time() {
		return store_avg_time;
	}

	public void setStore_avg_time(String store_avg_time) {
		this.store_avg_time = store_avg_time;
	}

	public String getStore_images_url() {
		return store_images_url;
	}

	public void setStore_images_url(String store_images_url) {
		this.store_images_url = store_images_url;
	}

	public String getStore_type_name() {
		return store_type_name;
	}

	public void setStore_type_name(String store_type_name) {
		this.store_type_name = store_type_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}

	public String getStore_business_hour() {
		return store_business_hour;
	}

	public void setStore_business_hour(String store_business_hour) {
		this.store_business_hour = store_business_hour;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
