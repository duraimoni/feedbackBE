package com.atos.feedback.vo;

public class ProductRateVO {

	private Long productRateId;
	private Long productId;
	private String comment;
	private int rating;
	private int month;
	private int year;
	private String ratingDesc;
	
	
	public String getRatingDesc() {
		return ratingDesc;
	}

	public void setRatingDesc(String ratingDesc) {
		this.ratingDesc = ratingDesc;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}



	public Long getProductRateId() {
		return productRateId;
	}

	public void setProductRateId(Long productRateId) {
		this.productRateId = productRateId;
	}

	 
 
}
