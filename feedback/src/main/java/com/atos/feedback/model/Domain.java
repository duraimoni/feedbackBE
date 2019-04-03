package com.atos.feedback.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.transaction.annotation.Transactional;


/**
 * The persistent class for the domain database table.
 * 
 */
@Entity
@NamedQuery(name="Domain.findAll", query="SELECT d FROM Domain d")
@NamedQuery(name="Domain.findAllByStatus", query="SELECT d FROM Domain d WHERE d.status=1")
@NamedQuery(name="Domain.findByUser", query="SELECT d FROM Domain d WHERE d.user1.userId= :userId")
@Transactional
@NamedQuery(name="Domain.updateStatus", query="UPDATE Domain d SET d.status=-1 WHERE d.domainId= :domainId")
public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="domain_id")
	private Long domainId;

	@Column(name="domain_desc")
	private String domainDesc;

	@Column(name="domain_name")
	private String domainName;

	private int status;

	private int updby;

	private Timestamp updtime;

	//bi-directional many-to-one association to AppUser
	@OneToMany(mappedBy="domain")
	private List<AppUser> appUsers;

	//bi-directional many-to-one association to User
	@OneToOne
	@JoinColumn(name="domain_leader")
	private User user1;

	//bi-directional many-to-one association to User
	@OneToOne
	@JoinColumn(name="domain_manager")
	private User user2;

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

	public int getUpdby() {
		return this.updby;
	}

	public void setUpdby(int updby) {
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

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
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