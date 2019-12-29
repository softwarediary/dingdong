package com.dd.action;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.dd.dao.RewardDao;
import com.dd.dao.UrDao;
import com.dd.dao.Userdao;
import com.dd.model.Habit;
import com.dd.model.Reward;
import com.dd.model.Ur;
import com.dd.model.User;
@Controller @Scope("prototype")
public class RewardAction extends ActionSupport{
@Resource RewardDao rewardDao;
@Resource UrDao urDao;
@Resource Userdao userDao;
	private Reward reward;
	private List<Reward> rewardList;
	private User user;
	private Ur ur;
	public Ur getUr() {
		return ur;
	}

	public void setUr(Ur ur) {
		this.ur = ur;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}
	
	public String addReward(){
		rewardDao.addReward(reward);
		return "messager";
	}
	
	public List<Reward> getRewardList() {
		return rewardList;
	}

	public void setRewardList(List<Reward> rewardList) {
		this.rewardList = rewardList;
	}
	
	public String showReward(){
		rewardList=rewardDao.QueryAllReward();
		return "show_reward";
	}
	
	public String editReward() throws Exception {
    	System.out.println("编辑奖励");
    	Reward r=rewardDao.GetRewardById(reward.getRid());
    	rewardDao.UpdateReward(reward);
        return "edit_messager";
    }
 public String getRe() throws Exception {
	 reward = rewardDao.GetRewardById(reward.getRid());
	user=userDao.QueryUserInfo(user.getUname()).get(0);
	System.out.println("1");

	if(urDao.QueryUrInfo(user, reward)){
		System.out.println("已领过");
	 return "detail_viewr";
	}
	else if(reward.getRvalue()<user.getUvalue()  || reward.getRvalue()==user.getUvalue()){
		user.setUvalue(user.getUvalue()-reward.getRvalue());
		 userDao.updateUser(user);
		 Ur u=new Ur();
		 u.setReward(reward);
		 u.setUser(user);
		 urDao.AddUr(u);
			System.out.println("领取");

		 return "succ_get";
	}
	else {
		System.out.println("不能领");

		return "failed_get";
	}
 }
 
 public String deleteReward() throws Exception {
	 rewardDao.deleteReward(reward.getRid());
	 return "delete_messager";
 }

 private String rname;
 public String getRname(){
	 return rname;
 }
 public void setRname(String rname){
	 this.rname=rname;
 }
 
 public String selectReward(){
	 rewardList=rewardDao.QueryReward(rname);
	 return "show_reward";
 }
 
 public String showDetail(){
	 reward=rewardDao.GetRewardById(reward.getRid());
	 return "detail_viewr";
 }



}
