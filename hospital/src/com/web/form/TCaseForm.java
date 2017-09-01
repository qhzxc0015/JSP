package com.web.form;

import org.apache.struts.action.ActionForm;

/**
 * TCase entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TCaseForm extends ActionForm implements java.io.Serializable {

	// Fields

	private Integer id;
	private String casename;
	private String userid;
	private String doctor;
	private String usermg;
	private String doctormg;
	private String inputdate;
	private String status;

	// Constructors

	/** default constructor */
	public TCaseForm() {
	}

	/** minimal constructor */
	public TCaseForm(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TCaseForm(Integer id, String casename, String userid, String doctor,
			String usermg, String doctormg, String inputdate, String status) {
		this.id = id;
		this.casename = casename;
		this.userid = userid;
		this.doctor = doctor;
		this.usermg = usermg;
		this.doctormg = doctormg;
		this.inputdate = inputdate;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCasename() {
		return this.casename;
	}

	public void setCasename(String casename) {
		this.casename = casename;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getUsermg() {
		return this.usermg;
	}

	public void setUsermg(String usermg) {
		this.usermg = usermg;
	}

	public String getDoctormg() {
		return this.doctormg;
	}

	public void setDoctormg(String doctormg) {
		this.doctormg = doctormg;
	}

	public String getInputdate() {
		return this.inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}