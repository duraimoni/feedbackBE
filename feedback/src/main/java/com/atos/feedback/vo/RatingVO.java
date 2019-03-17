package com.atos.feedback.vo;

public class RatingVO {

	private Long productId;
	private String productDescrption;
	private String productName;
	private int status;
//	private Integer domain;
	private String productLeader;
	private DomainVO domainVo;
	private ProductRateVO productRateVO;
	
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
/*	public Integer getDomain() {
		return domain;
	}
	public void setDomain(Integer domain) {
		this.domain = domain;
	}*/
/*	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}*/
	public DomainVO getDomainVo() {
		return domainVo;
	}
	public void setDomainVo(DomainVO domainVo) {
		this.domainVo = domainVo;
	}
	public String getProductLeader() {
		return productLeader;
	}
	public void setProductLeader(String productLeader) {
		this.productLeader = productLeader;
	}
	public ProductRateVO getProductRateVO() {
		return productRateVO;
	}
	public void setProductRateVO(ProductRateVO productRateVO) {
		this.productRateVO = productRateVO;
	}

	 
}
