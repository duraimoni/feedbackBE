package com.atos.feedback.vo;

public class ProductVO {

	private int productId;
	private String productDescrption;
	private String productName;
	private int status;
	private Integer domain;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductDescrption() {
		return productDescrption;
	}

	public void setProductDescrption(String productDescrption) {
		this.productDescrption = productDescrption;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDomain() {
		return domain;
	}

	public void setDomain(Integer domain) {
		this.domain = domain;
	}

}
