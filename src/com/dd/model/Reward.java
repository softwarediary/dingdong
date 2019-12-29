package com.dd.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Reward entity. @author MyEclipse Persistence Tools
 */

public class Reward implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rpic;
	private String rcontent;
	private Integer rvalue;
	private Integer uid;
	private Set urs = new HashSet(0);
	private Set urs_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Reward() {
	}

	/** full constructor */
	public Reward(String rpic, String rcontent, Integer rvalue, Integer uid,
			Set urs, Set urs_1) {
		this.rpic = rpic;
		this.rcontent = rcontent;
		this.rvalue = rvalue;
		this.uid = uid;
		this.urs = urs;
		this.urs_1 = urs_1;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRpic() {
		return this.rpic;
	}

	public void setRpic(String rpic) {
		this.rpic = rpic;
	}

	public String getRcontent() {
		return this.rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public Integer getRvalue() {
		return this.rvalue;
	}

	public void setRvalue(Integer rvalue) {
		this.rvalue = rvalue;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Set getUrs() {
		return this.urs;
	}

	public void setUrs(Set urs) {
		this.urs = urs;
	}

	public Set getUrs_1() {
		return this.urs_1;
	}

	public void setUrs_1(Set urs_1) {
		this.urs_1 = urs_1;
	}

}