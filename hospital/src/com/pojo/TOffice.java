package com.pojo;

/**
 * TOffice entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TOffice implements java.io.Serializable {

	// Fields

	private Integer id;
	private String officename;
	private String scope;
	private String device;
	private String statertime;

	// Constructors

	/** default constructor */
	public TOffice() {
	}

	/** minimal constructor */
	public TOffice(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TOffice(Integer id, String officename, String scope, String device,
			String statertime) {
		this.id = id;
		this.officename = officename;
		this.scope = scope;
		this.device = device;
		this.statertime = statertime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOfficename() {
		return this.officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getDevice() {
		return this.device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getStatertime() {
		return this.statertime;
	}

	public void setStatertime(String statertime) {
		this.statertime = statertime;
	}

}