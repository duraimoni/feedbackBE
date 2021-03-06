package com.atos.feedback.vo;

public class DomainVO {

	private Long domainId;
	private String domainName;
	private String domainDesc;
	private String domainLeader;
	private Long domainLeaderId;
 
	
	private String domainManager;
	private Long domainManagerId;

	public Long getDomainLeaderId() {
		return domainLeaderId;
	}

	public void setDomainLeaderId(Long domainLeaderId) {
		this.domainLeaderId = domainLeaderId;
	}

	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainDesc() {
		return domainDesc;
	}

	public void setDomainDesc(String domainDesc) {
		this.domainDesc = domainDesc;
	}

	public String getDomainLeader() {
		return domainLeader;
	}

	public void setDomainLeader(String domainLeader) {
		this.domainLeader = domainLeader;
	}

	public String getDomainManager() {
		return domainManager;
	}

	public void setDomainManager(String domainManager) {
		this.domainManager = domainManager;
	}

	public Long getDomainManagerId() {
		return domainManagerId;
	}

	public void setDomainManagerId(Long domainManagerId) {
		this.domainManagerId = domainManagerId;
	}

}
