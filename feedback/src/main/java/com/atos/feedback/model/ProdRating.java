package com.atos.feedback.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the prod_rating database table.
 * 
 */
@Entity
@Table(name="prod_rating")
@NamedQuery(name="ProdRating.findAll", query="SELECT p FROM ProdRating p")
public class ProdRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prod_rating_id")
	private int prodRatingId;

	private String comment;

	private int month;

	private int status;

	private int updby;

	private Timestamp updtime;

	private int year;

	//bi-directional many-to-one association to Rating
	@ManyToOne
	@JoinColumn(name="rating_id")
	private Rating rating;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProdRating() {
	}

	public int getProdRatingId() {
		return this.prodRatingId;
	}

	public void setProdRatingId(int prodRatingId) {
		this.prodRatingId = prodRatingId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
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

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Rating getRating() {
		return this.rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}