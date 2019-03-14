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
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p where p.status !=-1")
@Transactional
@NamedQuery(name="Product.updateStatus", query="UPDATE Product d SET d.status=-1 WHERE d.productId= :productId")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private Long productId;

	@Column(name="domain_id")
	private int domainId;

	@Column(name="product_descrption")
	private String productDescrption;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_owner")
	private int productOwner;

	private int status;

	private String updby;

	private Timestamp updtime;

	//bi-directional many-to-one association to ProdRating
	@OneToMany(mappedBy="product")
	private List<ProdRating> prodRatings;

	public Product() {
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getDomainId() {
		return this.domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
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

	public int getProductOwner() {
		return this.productOwner;
	}

	public void setProductOwner(int productOwner) {
		this.productOwner = productOwner;
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

}