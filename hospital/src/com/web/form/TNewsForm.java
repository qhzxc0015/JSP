package com.web.form;

import org.apache.struts.action.ActionForm;

/**
 * TNews entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TNewsForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Integer id;
	private String news;
	private String pills;
	private Float price;

	// Constructors

	/** default constructor */
	public TNewsForm() {
	}

	/** minimal constructor */
	public TNewsForm(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TNewsForm(Integer id, String news, String pills, Float price) {
		this.id = id;
		this.news = news;
		this.pills = pills;
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNews() {
		return this.news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getPills() {
		return this.pills;
	}

	public void setPills(String pills) {
		this.pills = pills;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}