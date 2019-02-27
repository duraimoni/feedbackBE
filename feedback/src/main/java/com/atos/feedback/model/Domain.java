package com.atos.feedback.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the domain database table.
 * 
 */
@Entity
@NamedQuery(name="Domain.findAll", query="SELECT d FROM Domain d")
public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="domain_id")
	private Long domainId;

	@Column(name="domain_desc")
	private String domainDesc;

	@Column(name="domain_leader")
	private int domainLeader;

	@Column(name="domain_name")
	private String domainName;

	private int status;

	private String updby;

	private Timestamp updtime;

	//bi-directional many-to-one association to AppUser
	@OneToMany(mappedBy="domain")
	private List<AppUser> appUsers;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="domain")
	private List<Product> products;

	public Domain() {
	}

	public Long getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public String getDomainDesc() {
		return this.domainDesc;
	}

	public void setDomainDesc(String domainDesc) {
		this.domainDesc = domainDesc;
	}

	public int getDomainLeader() {
		return this.domainLeader;
	}

	public void setDomainLeader(int domainLeader) {
		this.domainLeader = domainLeader;
	}

	public String getDomainName() {
		return this.domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUpdby() {
		return this.updby;
	}

	public void setUpdby(String updby) {
		this.updby = updby;
	}

	public Timestamp getUpdtime() {
		return this.updtime;
	}

	public void setUpdtime(Timestamp updtime) {
		this.updtime = updtime;
	}

	public List<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public AppUser addAppUser(AppUser appUser) {
		getAppUsers().add(appUser);
		appUser.setDomain(this);

		return appUser;
	}

	public AppUser removeAppUser(AppUser appUser) {
		getAppUsers().remove(appUser);
		appUser.setDomain(null);

		return appUser;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setDomain(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setDomain(null);

		return product;
	}

}