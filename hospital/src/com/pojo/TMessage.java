package com.pojo;

/**
 * TMessage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TMessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private String message;
	private String inputdate;
	private String user;
	private String doctor;
	private String reply;

	// Constructors

	/** default constructor */
	public TMessage() {
	}

	/** minimal constructor */
	public TMessage(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TMessage(Integer id, String message, String inputdate, String user,
			String doctor) {
		this.id = id;
		this.message = message;
		this.inputdate = inputdate;
		this.user = user;
		this.doctor = doctor;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInputdate() {
		return this.inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

}