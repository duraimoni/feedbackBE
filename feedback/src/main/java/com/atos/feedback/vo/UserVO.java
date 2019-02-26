package com.atos.feedback.vo;

public class UserVO {

	private Long userId;
	private String firstName;
	private String lastName;
	private String password;
	private Integer domain;
	private Integer product;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDomain() {
		return domain;
	}

	public void setDomain(Integer domain) {
		this.domain = domain;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

}
