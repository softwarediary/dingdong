package com.dd.model;

/**
 * Habit entity. @author MyEclipse Persistence Tools
 */

public class Habit implements java.io.Serializable {

	// Fields

	private Integer hid;
	private User user;
	private String hname;
	private String pic;
	private Integer totalNum;
	private Integer finishedNum;
	private String htext;
	private Integer hvalue;

	// Constructors

	/** default constructor */
	public Habit() {
	}

	/** minimal constructor */
	public Habit(User user) {
		this.user = user;
	}

	/** full constructor */
	public Habit(User user, String hname, String pic, Integer totalNum,
			Integer finishedNum, String htext, Integer hvalue) {
		this.user = user;
		this.hname = hname;
		this.pic = pic;
		this.totalNum = totalNum;
		this.finishedNum = finishedNum;
		this.htext = htext;
		this.hvalue = hvalue;
	}

	// Property accessors

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHname() {
		return this.hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getFinishedNum() {
		return this.finishedNum;
	}

	public void setFinishedNum(Integer finishedNum) {
		this.finishedNum = finishedNum;
	}

	public String getHtext() {
		return this.htext;
	}

	public void setHtext(String htext) {
		this.htext = htext;
	}

	public Integer getHvalue() {
		return this.hvalue;
	}

	public void setHvalue(Integer hvalue) {
		this.hvalue = hvalue;
	}

}