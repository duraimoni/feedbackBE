package com.atos.feedback.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the application database table.
 * 
 */
@Entity
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="app_id")
	private int appId;

	@Column(name="app_desc")
	private String appDesc;

	@Column(name="app_name")
	private String appName;

	private int status;

	private int updby;

	private Timestamp updtime;

	//bi-directional many-to-one association to AppUser
	@OneToMany(mappedBy="application")
	private List<AppUser> appUsers;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public Application() {
	}

	public int getAppId() {
		return this.appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppDesc() {
		return this.appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
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
		appUser.setApplication(this);

		return appUser;
	}

	public AppUser removeAppUser(AppUser appUser) {
		getAppUsers().remove(appUser);
		appUser.setApplication(null);

		return appUser;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}