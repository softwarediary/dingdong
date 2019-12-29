package com.dd.model;

/**
 * Ur entity. @author MyEclipse Persistence Tools
 */

public class Ur implements java.io.Serializable {

	// Fields

	private Integer urid;
	private Reward reward;
	private User user;

	// Constructors

	/** default constructor */
	public Ur() {
	}

	/** full constructor */
	public Ur(Reward reward, User user) {
		this.reward = reward;
		this.user = user;
	}

	// Property accessors

	public Integer getUrid() {
		return this.urid;
	}

	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	public Reward getReward() {
		return this.reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}