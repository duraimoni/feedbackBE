package com.atos.feedback.vo;

public class ProductVO {

	private Long productId;
	private String productDescrption;
	private String productName;
	private int status;
	private DomainVO domainVo;
	private ProductRateVO productRateVO;
	private Long domainId;
	
	private String productLeader;
	private Long productLeaderId;
	private String productLeaderEmail;
	
	private String productManager;
	private Long productManagerId;
	 
	
	public Long getProductLeaderId() {
		return productLeaderId;
	}
	public void setProductLeaderId(Long productLeaderId) {
		this.productLeaderId = productLeaderId;
	}
	public Long getDomainId() {
		return domainId;
	}
	public void setDomainId(Long domainId) {
		this.domainId = domainId;
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
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}
	public Long getProductManagerId() {
		return productManagerId;
	}
	public void setProductManagerId(Long productManagerId) {
		this.productManagerId = productManagerId;
	}
	public String getProductLeaderEmail() {
		return productLeaderEmail;
	}
	public void setProductLeaderEmail(String productLeaderEmail) {
		this.productLeaderEmail = productLeaderEmail;
	}
	 

	 
}
