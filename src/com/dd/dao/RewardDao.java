package com.dd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dd.model.Habit;
import com.dd.model.Reward;
@Service@Transactional
public class RewardDao {
	@Resource SessionFactory factory;
	
	public void addReward(Reward reward){
		Session s= factory.getCurrentSession();
		s.save(reward);
		
	}
	
	public void deleteReward(Integer rid){
		Session s= factory.getCurrentSession();
		Object reward= s.load(Reward.class, rid);
		s.delete(reward);
		
	}
	
    public void UpdateReward(Reward reward) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(reward);
    }	
	public ArrayList<Reward> QueryAllReward() {
        Session s = factory.getCurrentSession();
        String hql = "From Reward";
        Query q = s.createQuery(hql);
        List rewardList = q.list();
        return (ArrayList<Reward>) rewardList;
    }
    
    public Reward GetRewardById(Integer rid) {
        Session s = factory.getCurrentSession();
        Reward reward = (Reward)s.get(Reward.class, rid);
        return reward;
    }
    
    public ArrayList<Reward> QueryReward(String rname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Reward reward where 1=1";
    	if(!rname.equals("")) hql = hql + " and reward.rcontent like '%" + rname + "%'";
    	Query q = s.createQuery(hql);
    	List rewardList = q.list();
    	return (ArrayList<Reward>) rewardList;
    }
	
}
