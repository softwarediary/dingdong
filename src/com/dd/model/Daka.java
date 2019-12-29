package com.dd.model;

import java.util.Date;

/**
 * Daka entity. @author MyEclipse Persistence Tools
 */

public class Daka implements java.io.Serializable {

	// Fields

	private Integer did;
	private Habit habit;
	private Date dakadate;
	private String content;

	// Constructors

	/** default constructor */
	public Daka() {
	}

	/** minimal constructor */
	public Daka(Habit habit) {
		this.habit = habit;
	}

	/** full constructor */
	public Daka(Habit habit, Date dakadate, String content) {
		this.habit = habit;
		this.dakadate = dakadate;
		this.content = content;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Habit getHabit() {
		return this.habit;
	}

	public void setHabit(Habit habit) {
		this.habit = habit;
	}

	public Date getDakadate() {
		return this.dakadate;
	}

	public void setDakadate(Date dakadate) {
		this.dakadate = dakadate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}