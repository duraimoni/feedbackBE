package com.atos.feedback.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rating_id")
	private Long ratingId;

	@Column(name="rating_desc")
	private String ratingDesc;

	@Column(name="rating_no")
	private int ratingNo;

	private int status;

	//bi-directional many-to-one association to ProdRating
	@OneToMany(mappedBy="rating")
	private List<ProdRating> prodRatings;

	public Rating() {
	}

	public Long getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingDesc() {
		return this.ratingDesc;
	}

	public void setRatingDesc(String ratingDesc) {
		this.ratingDesc = ratingDesc;
	}

	public int getRatingNo() {
		return this.ratingNo;
	}

	public void setRatingNo(int ratingNo) {
		this.ratingNo = ratingNo;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<ProdRating> getProdRatings() {
		return this.prodRatings;
	}

	public void setProdRatings(List<ProdRating> prodRatings) {
		this.prodRatings = prodRatings;
	}

	public ProdRating addProdRating(ProdRating prodRating) {
		getProdRatings().add(prodRating);
		prodRating.setRating(this);

		return prodRating;
	}

	public ProdRating removeProdRating(ProdRating prodRating) {
		getProdRatings().remove(prodRating);
		prodRating.setRating(null);

		return prodRating;
	}

}