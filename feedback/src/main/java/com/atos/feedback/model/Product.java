package com.atos.feedback.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p where p.status !=-1")
@NamedQuery(name = "Product.findAllrate", query = "SELECT p FROM Product p left join ProdRating pr on p.productId=pr.product and pr.month= :month and pr.year =:year where  p.status !=-1 ")
@Transactional
@NamedQuery(name = "Product.updateStatus", query = "UPDATE Product d SET d.status=-1 WHERE d.productId= :productId")

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_descrption")
	private String productDescrption;

	@Column(name = "product_name")
	private String productName;

	private int status;

	private int updby;

	private Timestamp updtime;

	// bi-directional many-to-one association to AppUser
	@OneToMany(mappedBy = "product")
	private List<AppUser> appUsers;

	// bi-directional many-to-one association to Application
	@OneToMany(mappedBy = "product")
	private List<Application> applications;

	// bi-directional many-to-one association to ProdRating
	@OneToMany(mappedBy = "product")
	private List<ProdRating> prodRatings;

	// bi-directional many-to-one association to Domain
	@ManyToOne
	@JoinColumn(name = "domain_id")
	private Domain domain;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "product_owner")
	private User user;

	public Product() {
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductDescrption() {
		return this.productDescrption;
	}

	public void setProductDescrption(String productDescrption) {
		this.productDescrption = productDescrption;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
		appUser.setProduct(this);

		return appUser;
	}

	public AppUser removeAppUser(AppUser appUser) {
		getAppUsers().remove(appUser);
		appUser.setProduct(null);

		return appUser;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setProduct(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setProduct(null);

		return application;
	}

	public List<ProdRating> getProdRatings() {
		return this.prodRatings;
	}

	public void setProdRatings(List<ProdRating> prodRatings) {
		this.prodRatings = prodRatings;
	}

	public ProdRating addProdRating(ProdRating prodRating) {
		getProdRatings().add(prodRating);
		prodRating.setProduct(this);

		return prodRating;
	}

	public ProdRating removeProdRating(ProdRating prodRating) {
		getProdRatings().remove(prodRating);
		prodRating.setProduct(null);

		return prodRating;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}