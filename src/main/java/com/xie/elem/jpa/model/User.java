package com.xie.elem.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * 实体类user
 * 
 * @author xie
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
	// public class User implements UserDetails {
	private static final long SerialVerionUID = 1L;

	public static long getSerialverionuid() {
		return SerialVerionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@NotBlank(message = "用户名不能为空")
	@Length(min = 2, message = "用户名长度至少为2")
	@Length(max = 10, message = "用户名长度最大为10")
	@Size(min = 2, max = 10)
	@Column(name = "username", nullable = false)
	private String username;

	@NotBlank(message = "密码不能为空")
	@Length(min = 8, message = "密码长度至少为8")
	private String password;

	/*
	 * 0 admin 1 用户， 2 商家，
	 */

	private Integer usertype;

	@Column(name = "avatar", columnDefinition = "varchar(255) DEFAULT 'https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3412962733,974670695&fm=58'", nullable = false)
	private String avatar = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3412962733,974670695&fm=58";// 头像


	@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号格式错误")
	private String telephone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



}
