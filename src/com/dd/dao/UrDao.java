package com.dd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dd.model.User;
import com.dd.model.Reward;
import com.dd.model.Ur;


@Service @Transactional
public class UrDao {
	@Resource SessionFactory factory;
	
	 //添加用户领奖
    public void AddUr(Ur ur) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(ur);
    }
    

    //查询该用户是否领取过该奖励，若是，则返回true,否则false
    public Boolean QueryUrInfo(User user, Reward reward) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Ur ur where 1=1";
    	
    	if(null != user && user.getUid()!=0) 
    		hql = hql + " and ur.user.uid like '%" + user.getUid() + "%'";
    	if(null != reward && null!=reward.getRid()) 
    		hql = hql + " and ur.reward.rid like '%" + reward.getRid() + "%'";
    	System.out.print(hql);

    	Query q = s.createQuery(hql);
    	System.out.print("222");

    	if(q.list().size()>0){
        	System.out.print("111");

    		return true;
    	}
    	return false;
    }

}
