package com.atos.feedback.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedQuery(name = "User.findAllByStatus", query = "SELECT u FROM User u where u.status!=-1")
@NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u where u.changePassword!=0")
@Transactional
@NamedQuery(name="User.updateStatus", query="UPDATE User d SET d.status=1 WHERE d.userId= :userId")
@NamedQuery(name="User.deleteUser", query="UPDATE User d SET d.status=-1 WHERE d.userId= :userId")
@NamedQuery(name="User.changePassword", query="UPDATE User d SET d.password= :password, d.changePassword=1 WHERE d.userId= :userId")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	 

	public User(User user) {
		this.userId = user.getUserId();
		this.roles = user.getRoles();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.email = user.getEmail();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String password;

	private int status;

	private Timestamp updtime;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "change_password")
	private int changePassword;

	@Column(name = "email")
	private String email;

	// bi-directional many-to-one association to AppUser
	@OneToMany(mappedBy = "user1")
	private List<AppUser> appUsers;

	// bi-directional one-to-one association to AppUser
	@OneToOne(mappedBy = "user1", cascade = { CascadeType.ALL })
	private AppUser appUser;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "user3")
	private List<Product> products3;
	
	@OneToMany(mappedBy = "user4")
	private List<Product> products4;

	// bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<Role> roles;

	public User() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getUpdtime() {
		return this.updtime;
	}

	public void setUpdtime(Timestamp updtime) {
		this.updtime = updtime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public AppUser addAppUser(AppUser appUser) {
		getAppUsers().add(appUser);
		appUser.setUser1(this);

		return appUser;
	}

	public AppUser removeAppUser(AppUser appUser) {
		getAppUsers().remove(appUser);
		appUser.setUser1(null);

		return appUser;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public List<Product> getProducts3() {
		return products3;
	}

	public void setProducts3(List<Product> products3) {
		this.products3 = products3;
	}

	public List<Product> getProducts4() {
		return products4;
	}

	public void setProducts4(List<Product> products4) {
		this.products4 = products4;
	}

	public Product addProduct3(Product product) {
		getProducts3().add(product);
		product.setUser3(this);
		return product;
	}

	public Product removeProduct3(Product product) {
		getProducts3().remove(product);
		product.setUser3(null);
		return product;
	}
	public Product addProduct4(Product product) {
		getProducts4().add(product);
		product.setUser4(this);
		return product;
	}

	public Product removeProduct4(Product product) {
		getProducts4().remove(product);
		product.setUser4(null);
		return product;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(int changePassword) {
		this.changePassword = changePassword;
	}

}